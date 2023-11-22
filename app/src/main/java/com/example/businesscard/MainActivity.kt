package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardView("Android")
                }
            }
        }
    }
}

@Composable
fun BusinessCardView(name: String, modifier: Modifier = Modifier) {
    val androidLogoPointer = painterResource(id = R.drawable.android_logo)

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
          Column(
              modifier = Modifier.fillMaxHeight(0.5f),
              verticalArrangement = Arrangement.Center,
              horizontalAlignment = Alignment.CenterHorizontally,
          ){
              Row(modifier = Modifier.fillMaxWidth(0.3f).size(110.dp).clip(RoundedCornerShape(6.dp))){
                  Image(
                      painter = androidLogoPointer,
                      contentDescription = stringResource(R.string.android_logo),
                      modifier = modifier
                          .background(Color(android.graphics.Color.parseColor("#073042")))
                      ,
                      contentScale = ContentScale.FillWidth
                  )
              }
              Spacer(modifier = Modifier.height(4.dp))

              Text(
                  text = stringResource(R.string.name),
                  textAlign = TextAlign.Center,
                  lineHeight = 74.sp,
                  fontSize = 45.sp,
              )

              Spacer(modifier = Modifier.height(4.dp))

              Text(
                  text = "Android Developer Extraordinaire",
                  fontSize = 18.sp,
                  fontWeight = FontWeight(600),
                  color = Color(android.graphics.Color.parseColor("#006c3a"))

              )

              Spacer(modifier = Modifier.height(4.dp))
          }


        }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardViewPreview() {
    BusinessCardTheme {
        BusinessCardView("Android", modifier = Modifier.fillMaxSize())
    }
}
