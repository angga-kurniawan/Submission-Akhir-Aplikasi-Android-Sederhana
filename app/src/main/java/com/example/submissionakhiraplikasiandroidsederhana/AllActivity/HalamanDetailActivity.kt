package com.example.submissionakhiraplikasiandroidsederhana.AllActivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.submissionakhiraplikasiandroidsederhana.AllClass.listDitailBrand
import com.example.submissionakhiraplikasiandroidsederhana.AllClass.nameBrand
import com.example.submissionakhiraplikasiandroidsederhana.AllClass.productImgBrand
import com.example.submissionakhiraplikasiandroidsederhana.AllClass.productNameBrand
import com.example.submissionakhiraplikasiandroidsederhana.R
import com.example.submissionakhiraplikasiandroidsederhana.ui.theme.SubmissionAkhirAplikasiAndroidSederhanaTheme

class HalamanDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val setIntentNameBrand = intent.getStringExtra("GET_EXTRA_NAME_BRAND")
        val setIndex = intent.getIntExtra("INDEX", 0)
        setContent {
            MainDetail(setIndex = setIndex)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainDetail(setIndex: Int) {
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
                    RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp)
                ),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            val intent = Intent(createContext, MainActivity::class.java)
                            createContext.startActivity(intent)
                            (createContext as? Activity)?.finish()
                        },
                        content = {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "back",
                                tint = Color(0xFF990100)
                            )
                        }
                    )
                }
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                content = {
                    Image(
                        painter = painterResource(id = R.drawable.bg),
                        contentDescription = "BG",
                        modifier = Modifier.blur(10.dp)
                    )
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .verticalScroll(rememberScrollState()),
                        content = {
                            MainDetailLine1(setIndex = setIndex)
                            Spacer(modifier = Modifier.padding(5.dp))
                            MainDetailLine2(setIndex = setIndex)
                            Spacer(modifier = Modifier.padding(5.dp))
                            MainDetailLine3(setIndex = setIndex)
                        }
                    )
                }
            )
        }
    )
}

@Composable
fun MainDetailLine1(setIndex: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .shadow(2.dp, RoundedCornerShape(10.dp))
            .background(Color(0x99FFFFFF))
            .padding(10.dp),
        content = {
            Image(
                painter = rememberAsyncImagePainter(listDitailBrand[setIndex].setImgCompenyBrand),
                contentDescription = "profile",
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()
                    .shadow(2.dp, RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.padding(2.5.dp))
            Column(
                modifier = Modifier
                    .shadow(2.dp, RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(5.dp),
                content = {
                    Text(
                        text = listDitailBrand[setIndex].setNameBrand,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF990100),
                        fontSize = 20.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        text = "Founder :",
                        fontSize = 10.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                        text = listDitailBrand[setIndex].setFounder,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        text = "Year Established :",
                        fontSize = 10.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                        text = listDitailBrand[setIndex].setYearEstablished,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        text = "Total Products :",
                        fontSize = 10.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                        text = listDitailBrand[setIndex].setTotalProduct,
                        fontSize = 10.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(
                        text = "Total Users :",
                        fontSize = 10.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize(),
                        content = {
                            Text(
                                text = listDitailBrand[setIndex].setTotalUsers,
                                fontSize = 20.sp,
                                color = Color(0xFF990100),
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    )
                }
            )
        }
    )
}

@Composable
fun MainDetailLine2(setIndex: Int) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .shadow(2.dp, RoundedCornerShape(10.dp))
            .background(Color(0x99FFFFFF))
            .padding(5.dp),
        content = {
            items(
                count = productImgBrand[nameBrand[setIndex]]?.size ?: 0,
                itemContent = { index ->
                    Spacer(modifier = Modifier.padding(2.5.dp))
                    CardProductPhone(index = index, settIndex = setIndex)
                }
            )
        }
    )
}

@Composable
fun MainDetailLine3(setIndex: Int) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .shadow(1.dp, RoundedCornerShape(10.dp)) // Shadow diterapkan terlebih dahulu
            .background(
                color = Color(0x99FFFFFF),
                shape = RoundedCornerShape(10.dp) // Bentuk background disesuaikan dengan shadow
            )
            .padding(10.dp),
        content = {
            Text(
                text = listDitailBrand[setIndex].setDescBrand,
                fontSize = 10.sp
            )
        }
    )
}

@Composable
fun CardProductPhone(index: Int, settIndex: Int) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(150.dp),
        colors = CardDefaults.cardColors(
            Color.White
        ),
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                content = {
                    Image(
                        painter = rememberAsyncImagePainter(
                            productImgBrand[nameBrand[settIndex]]?.get(
                                index
                            )
                        ),
                        contentDescription = "img",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .shadow(2.dp, RoundedCornerShape(10.dp))
                            .fillMaxWidth()
                            .fillMaxHeight(0.9f)
                    )
                    Text(
                        text = productNameBrand[nameBrand[settIndex]]?.get(index) ?: "??????????",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    )
                }
            )
        }
    )
}

@Preview
@Composable
fun MainDetailLine1Prev() {
    MainDetailLine1(setIndex = 0)
}

@Preview
@Composable
fun MainDettailLine3Prev() {
    MainDetailLine3(0)
}

@Preview
@Composable
fun CardProductPhonePrev() {
    CardProductPhone(0, 0)
}

@Preview
@Composable
fun MainDetailPrev() {
    MainDetail(0)
}
