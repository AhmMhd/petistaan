/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Repository
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.bgDark
import com.example.androiddevchallenge.ui.theme.bgLight
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {

    Surface {
        var text = remember { mutableStateOf(TextFieldValue("Search")) }
        Column( horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.padding(top = 52.dp))

            OutlinedTextField(
                value = text.value,
                onValueChange = {
                    text.value = it
                },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_search_24),
                        contentDescription = "Search button"
                    )
                }
            )

            Text(
                text = "Choose Your Pet",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            )
            Text(
                text = "We have largest selection of pets.",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Cyan
                )
            )
            LazyColumn {
                items(Repository.getFakePets().size, itemContent = {
                    SinglePet()
                })
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}
//
//@Preview("Dark Theme", widthDp = 360, heightDp = 640)
//@Composable
//fun DarkPreview() {
//    MyTheme(darkTheme = true) {
//        MyApp()
//    }
//}


@Composable
fun SinglePet() {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 12.dp)
            .wrapContentHeight()
            .fillMaxWidth(),
        elevation = 4.dp,
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.mipmap.pet_1),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .padding(12.dp),
                contentScale = ContentScale.Inside
            )

            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Labordor Retreive",
                    style = TextStyle(
                        fontSize = 20.sp,
                    )
                )
                Row(Modifier.fillMaxWidth()) {
                    Text(
                        text = "Average Size: ",
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                    Text(
                        text = "55-60 lb",
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                }

                Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(
                        text = "Life Expectancy: ",
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                    Text(
                        text = "12 years",
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                }
                Row(horizontalArrangement = Arrangement.SpaceAround) {
                    Text(
                        text = "Age: ",
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                    Text(
                        text = "2 Years",
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                }
            }
        }
    }
}