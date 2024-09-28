package com.example.submissionakhiraplikasiandroidsederhana.AllActivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import coil.compose.rememberAsyncImagePainter
import com.example.submissionakhiraplikasiandroidsederhana.AllClass.Brand
import com.example.submissionakhiraplikasiandroidsederhana.AllClass.listDitailBrand
import com.example.submissionakhiraplikasiandroidsederhana.AllClass.nameBrand
import com.example.submissionakhiraplikasiandroidsederhana.R
import com.example.submissionakhiraplikasiandroidsederhana.ui.theme.SubmissionAkhirAplikasiAndroidSederhanaTheme
import okhttp3.internal.notify

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        println(installSplashScreen())
        setContent {
            MainHome()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainHome() {
    val createContext = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    Color(0xfffafafa)
                ),
                modifier = Modifier.shadow(
                    10.dp,
                    RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp)
                ),
                actions = {
                    IconButton(
                        onClick = {
                            val inten = Intent(createContext, HalamanAboutActivity()::class.java)
                            createContext.startActivity(inten)
                        },
                        content = {
                            Icon(
                                imageVector = Icons.Filled.MoreVert,
                                contentDescription = "TO ABOUT",
                                tint = Color(0xFF990100)
                            )
                        }
                    )
                }
            )
        },
        content = { it ->
            Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.bg),
                        contentDescription = "bg",
                        modifier = Modifier.blur(10.dp),
                        contentScale = ContentScale.Crop
                    )
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 10.dp, end = 10.dp),
                        content = {
                            items(
                                count = 10,
                                itemContent = { index ->
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    CardLayout(index = index, createContext = createContext)
                                }
                            )
                        }
                    )
                }
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardLayout(index: Int, createContext: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0x99FFFFFF)
        ),
        onClick = {
            val intent = Intent(createContext, HalamanDetailActivity::class.java).apply {
//                putExtra("GET_EXTRA_NAME_BRAND", nameBrand[index])
                putExtra("INDEX", index)
            }
            createContext.startActivity(intent)
        },
        content = {
            Row(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                content = {
                    Image(
                        painter = rememberAsyncImagePainter(listDitailBrand[index].setImgUrlBrand),
                        contentDescription = listDitailBrand[index].setNameBrand,
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(120.dp)
                            .shadow(10.dp, RoundedCornerShape(10.dp))
                            .clip(RoundedCornerShape(10.dp)),
                        contentScale = ContentScale.FillBounds
                    )
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxSize()
                            .background(Color.White),
                        content = {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                content = {
//                            Text(text = "Brand : ${listDitailBrand[index].setNameBrand}")
                                    Text(
                                        text = listDitailBrand[index].setNameBrand,
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF990100)
                                    )
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Text(text = "Desc :")
                                    Text(
                                        text = listDitailBrand[index].setDescBrand,
                                        fontWeight = FontWeight.Light,
                                        fontStyle = FontStyle.Italic,
                                        overflow = TextOverflow.Ellipsis,
                                        maxLines = 3,
                                        fontSize = 10.sp,
                                        color = Color(0xff3D3D3D)
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
fun CardLayoutPrev() {
//    CardLayout(0)
}

@Preview
@Composable
fun MainHomePrev() {
    MainHome()
}
