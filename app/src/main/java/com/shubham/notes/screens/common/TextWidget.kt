package com.shubham.notes.screens.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ProvideTextHeadings(text : String , fontSize : TextUnit = 20.sp) {
    Text(text = "Add Note" , fontSize = fontSize)
}


/**
 * By default this will be used to provide the vertical spacing if you need the horizontal space
 * please provide the width as well
 *
 * if you need only vertical spacing provide the height only
 * if you need only horizontal spacing then provide the width only
 *
 * @param height : provide the height required in Y axis
 * @param width : provide the width required in X axis
 *
 *
 * @return the space require in 2d space.
 * **/
@Composable
fun Spacer(height: Dp = 0.dp, width: Dp = 0.dp) {
    Box(
        modifier = Modifier
            .height(height)
            .width(width)
    )
}

@Composable
private fun GetPlaceHolder(
    text: String
) {
    Text(text, fontSize = 16.sp)
}


@Composable
fun GetTextFields(
    title: MutableState<String>,
    placeholderText: String,
    backgroundColor: Color = Color.White,
    cornerRadius: Dp = 10.dp,
    width: Float = 1f,
    textSize: TextUnit = 16.sp,
    trailingIcon: @Composable () -> Unit = {},
    maxLines: Int = 1,
    minLines: Int = 1,
    isSingleLine: Boolean = false
) {

    return TextField(
        value = title.value,
        onValueChange = { newTitle ->
            title.value = newTitle
        },
        placeholder = { GetPlaceHolder(placeholderText) },
        modifier = Modifier
            .clip(RoundedCornerShape(cornerRadius))
            .background(color = backgroundColor)
            .fillMaxWidth(width),
        textStyle = TextStyle(fontSize = textSize),
        singleLine = isSingleLine,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black,
        ),
        maxLines = maxLines,
        minLines = minLines,
        trailingIcon = { trailingIcon.invoke() }
    )
}