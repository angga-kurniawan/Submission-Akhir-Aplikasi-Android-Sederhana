package com.example.submissionakhiraplikasiandroidsederhana.AllActivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.submissionakhiraplikasiandroidsederhana.R
import com.example.submissionakhiraplikasiandroidsederhana.ui.theme.SubmissionAkhirAplikasiAndroidSederhanaTheme

class HalamanAboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainAbout()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAbout() {
    val createContext = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    Color(0xfffafafa)
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            val intent = Intent(createContext, MainActivity::class.java)
                            createContext.startActivity(intent)
                            (createContext as? Activity)?.finish()
                        },
                        content = {
//                                  Image(
//                                      painter = painterResource(id = R.drawable.back2),
//                                      contentDescription = "BACK",
//                                      modifier = Modifier.padding(start = 15.dp)
//                                  )
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "BACK",
                                tint = Color(0xFF990100)
                            )
                        }
                    )


                },
                modifier = Modifier.shadow(
                    10.dp,
                    RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                )
            )
        },
        content = {
            Box(
                modifier = Modifier.padding(it),
                contentAlignment = Alignment.TopCenter,
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.bg),
                        contentDescription = "BACKGROUND",
                        modifier = Modifier
                            .fillMaxSize()
                            .blur(10.dp)
                    )
                    Box(
                        modifier = Modifier
                            .padding(50.dp)
                            .shadow(20.dp, RoundedCornerShape(20.dp)),
                        content = {

                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(20.dp))
                                    .background(Color(0xfffafafa))
                                    .padding(10.dp)
                                    .height(400.dp)
                                    .width(250.dp),
                                contentAlignment = Alignment.Center,
                                content = {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center,
                                        content = {
                                            Image(
                                                painter = painterResource(id = R.drawable.profile),
                                                contentDescription = "PROFILE",
                                                contentScale = ContentScale.Crop,
                                                modifier = Modifier
                                                    .size(200.dp)
                                                    .shadow(10.dp, CircleShape)
                                                    .border(
                                                        2.dp, Color.Red,
                                                        CircleShape
                                                    )
                                            )
                                            Spacer(modifier = Modifier.padding(30.dp))
                                            Text(
                                                text = "ANGGA KURNIAWAN",
                                                fontWeight = FontWeight.Bold,
                                                fontSize = 20.sp
                                            )
                                            Text(
                                                text = "mtahakurniawan@gmail.com",
                                                fontWeight = FontWeight.ExtraLight
                                            )
                                        }
                                    )
                                }
                            )
                        }
                    )

                }
            )
        }
    )
}

@Preview
@Composable
fun MainAboutPrev() {
    MainAbout()
}