package br.senai.sp.jandira.lionschoolapplication.gui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschoolapplication.gui.ui.theme.LionSchoolApplicationTheme

class ChooseCourseActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolApplicationTheme {
                ChooseCourse()
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ChooseCourse() {
    val context = LocalContext.current

    //Column azul principal
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(51, 71, 176, 255),
                        Color(77, 93, 187),
                        Color(77, 93, 187, 255),
                        Color(76, 92, 187, 190),
                        Color(76, 92, 187, 150)
                    )
                )
            ),

        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Column(
            modifier = Modifier
                .padding(start = 0.dp, 70.dp, 0.dp, 0.dp)

                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            //ROW da image
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painterResource(id = br.senai.sp.jandira.lionschoolapplication.R.drawable.header_background),
                    modifier = Modifier.fillMaxSize(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            //ROW do card
            Row(
                modifier = Modifier
                    .padding(24.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 360.dp, height = 360.dp),

                    ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                Color(51, 71, 176),
                                shape = RoundedCornerShape(40.dp)
                            )
                            .padding(start = 0.dp, 22.dp, 0.dp, 0.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card(
                            modifier = Modifier
                                .height(6.dp)
                                .width(140.dp)
                                .background(Color.White, shape = RoundedCornerShape(30.dp)),
                        ) {
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        //COLUMN dos texts
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,

                            ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 0.dp, 20.dp, 0.dp, 10.dp),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = stringResource(id = br.senai.sp.jandira.lionschoolapplication.R.string.choose),
                                    color = Color.White,
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight(600)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = stringResource(id = br.senai.sp.jandira.lionschoolapplication.R.string.course),
                                    color = Color(255, 194, 70),
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight(900)
                                )
                            }
                            Text(
                                text = stringResource(id = br.senai.sp.jandira.lionschoolapplication.R.string.to_manage),
                                color = Color.White,
                                fontSize = 40.sp,
                                fontWeight = FontWeight(600)
                            )
                        }
                        Spacer(modifier = Modifier.height(36.dp))
                        //BUTTON
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Button(
                                onClick = {
                                          val openNext = Intent(context, MainActivity::class.java)
                                    context.startActivity(openNext)
                                },
                                modifier = Modifier
                                    .width(260.dp)
                                    .height(70.dp),
                                colors = ButtonDefaults
                                    .buttonColors(Color(255, 194, 70)),
                                shape = RoundedCornerShape(30.dp),
                            ) {
                                Text(
                                    text = stringResource(id = br.senai.sp.jandira.lionschoolapplication.R.string.click_here),
                                    fontSize = 34.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )
                            }

                        }

                    }

                }

            }


            Spacer(modifier = Modifier.height(14.dp))

//                Text(
//                    text = stringResource(id = R.string.lion_school),
//                    fontSize = 40.sp,
//                    fontWeight = FontWeight(800),
//                    color = Color.White
//                )
        }

    }
}
