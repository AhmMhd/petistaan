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
import androidx.compose.foundation.clickable
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
import com.example.androiddevchallenge.model.Pet
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

    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        var text = remember { mutableStateOf(TextFieldValue("Search")) }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(72.dp))

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
                    fontSize = 40.sp
                )
            )
            Text(
                text = "We have largest selection of pets.",
                style = TextStyle(
                    fontSize = 18.sp,
                )
            )
            LazyColumn {
                val pets = Repository.getFakePets()
                items(pets.size, itemContent = { index ->

                    Card(modifier = Modifier.fillMaxWidth().wrapContentWidth().padding(start = 16.dp,end = 16.dp,top = 6.dp)) {
                        Row(
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                                .clickable {

                                },
                        ) {
                            Image(
                                painter = painterResource(pets[index].avatar),
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
                                    text = "${pets[index].name}",
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
                                        text = "${pets[index].averageSize}",
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
                                        text = "${pets[index].lifeExpectancy}",
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
                                        text = "${pets[index].age}",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                        )
                                    )
                                }
                            }
                        }
                    }
                })
//            }
            }
        }
    }
}
@Preview()
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview()
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

@Composable
fun SinglePet(pet: Pet) {
    Card(modifier = Modifier.fillMaxWidth().wrapContentWidth().padding(start = 16.dp,end = 16.dp,top = 6.dp)) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .clickable {

                },
        ) {
            Image(
                painter = painterResource(pet.avatar),
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
                    text = "${pet.name}",
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
                        text = "${pet.averageSize}",
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
                        text = "${pet.lifeExpectancy}",
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
                        text = "${pet.age}",
                        style = TextStyle(
                            fontSize = 14.sp,
                        )
                    )
                }
            }
        }
    }
}