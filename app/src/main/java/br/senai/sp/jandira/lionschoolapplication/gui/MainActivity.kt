package br.senai.sp.jandira.lionschoolapplication.gui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschoolapplication.R
import br.senai.sp.jandira.lionschoolapplication.model.ListCursos
import br.senai.sp.jandira.lionschoolapplication.service.RetrofitFactory
import br.senai.sp.jandira.lionschoolapplication.ui.theme.LionSchoolApplicationTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolApplicationTheme {
                DefaultPreview()
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview() {
    val context = LocalContext.current
    var cursos by remember {
        mutableStateOf(listOf<br.senai.sp.jandira.lionschoolapplication.model.Cursos>())
    }
    val call = RetrofitFactory().getCursosService().getCursos()

    call.enqueue(object : Callback<ListCursos> {
        override fun onResponse(
            call: Call<ListCursos>,
            response: Response<ListCursos>
        ) {
            cursos = response.body()!!.cursos
        }

        override fun onFailure(call: Call<ListCursos>, t: Throwable) {
            Log.i("ds2m", "onFailure: $t")
        }

    })
    Log.i("ds2m", " $cursos")

    Surface(//abrange tudo
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    )
    {
        Column(//coluna principal
            modifier = Modifier.fillMaxSize()
        )
        {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(51, 71, 176, 255),
                                Color(77, 93, 187),
                                Color(77, 93, 187, 255),
                                Color(76, 92, 187, 190),
                                Color(76, 92, 187, 150)
                            )
                        ),
                        shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(horizontalArrangement = Arrangement.Center) {
                        Image(
                            painterResource(id = R.drawable.logo_lion4x),
                            contentDescription = "",
                            modifier = Modifier
                                .size(60.dp, 60.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = stringResource(id = R.string.lion_school_break_line),
                            fontSize = 24.sp,
                            fontWeight = FontWeight(800),
                            color = Color.White,
                        )
                    }
                }
            }


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.select_course),
                    color = Color(51, 71, 176),
                    fontWeight = FontWeight.Black,
                    fontSize = 30.sp,
                    modifier = Modifier.padding(top=50.dp, bottom = 30.dp),
                    textDecoration = TextDecoration.Underline

                )
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    items(cursos) { curso ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .clickable {
                                    val intent = Intent(context, AlunosActivity::class.java)
                                    intent.putExtra("sigla", curso.sigla)
                                    intent.putExtra("titulo", curso.nome)
                                    context.startActivity(intent)
                                },
                            shape = RoundedCornerShape(20.dp),
                            backgroundColor = Color.White,
                            border = BorderStroke(3.dp, Color(51, 71, 176))
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = curso.sigla,
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(51, 71, 176),
                                )
                            }
                        }
                    }
                }
            }
        } //fim da coluna principal
    } //fim da surface

}