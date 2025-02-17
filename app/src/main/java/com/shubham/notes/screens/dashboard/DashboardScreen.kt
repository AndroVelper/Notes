package com.shubham.notes.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shubham.notes.R
import com.shubham.notes.navigation.NavDestinations


@Composable
fun DashboardScreen(navController: NavController) {
    val title = remember { mutableStateOf("") }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(NavDestinations.AddNoteScreen.route)
            }) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add Button")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(
                vertical = innerPadding.calculateTopPadding() + 0.dp,
                horizontal = innerPadding.calculateLeftPadding(LayoutDirection.Ltr)
            )
        ) {
            Box(
                modifier = Modifier
                    .padding(15.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White) // Background applied to whole Box
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 5.dp, end = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .size(35.dp, 35.dp)
                            .padding(5.dp)
                            .clip(RoundedCornerShape(100.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_menu),
                            contentDescription = "Application Icon"
                        )
                    }

                    BasicTextField(
                        value = title.value,
                        onValueChange = { title.value = it },
                        singleLine = true,
                        modifier = Modifier
                            .weight(1f) // Allows text field to take available space but not overlap the icon
                            .padding(end = 10.dp, start = 10.dp), // Add some spacing from the icon
                        textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                        decorationBox = { innerTextField ->
                            if (title.value.isEmpty()) {
                                Text(
                                    text = "Search here ....",
                                    color = Color.Gray,
                                    fontSize = 16.sp
                                )
                            }
                            innerTextField()
                        }
                    )

                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.app_icon),
                            contentDescription = "Application Icon"
                        )
                    }


                }
            }

        }
    }
}

