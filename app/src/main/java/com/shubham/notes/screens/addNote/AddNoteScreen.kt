package com.shubham.notes.screens.addNote

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shubham.notes.database.DataBaseEvents
import com.shubham.notes.database.NoteEntity
import com.shubham.notes.screens.common.GetTextFields
import com.shubham.notes.screens.common.ProvideTextHeadings
import com.shubham.notes.screens.common.Spacer
import com.shubham.notes.screens.dashboard.DashboardViewModel
import com.shubham.notes.utils.ResponseManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import java.util.Date
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun AddNoteScreen(navController: NavController) {
    val title = remember { mutableStateOf("") }
    val desc = remember { mutableStateOf("") }
    val viewModel: DashboardViewModel = koinViewModel()

    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(
                    vertical = innerPadding.calculateTopPadding() + 20.dp,
                    horizontal = 15.dp
                )
        ) {

            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 0.dp)
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Back Button"
                        )
                    }
                    ProvideTextHeadings(text = "Add Note", fontSize = 20.sp)
                }
                Spacer(height = 30.dp)

                Column(
                    modifier = Modifier
                        .padding(
                            horizontal = 15.dp
                        )
                        .verticalScroll(rememberScrollState())
                        .imePadding(),
                ) {

                    GetTextFields(
                        title = title,
                        placeholderText = "Enter Title",
                        isSingleLine = true,
                        trailingIcon = {
                            if (title.value.isEmpty()) {
                                return@GetTextFields
                            }
                            IconButton(onClick = { title.value = "" }) {
                                Icon(imageVector = Icons.Filled.Clear, contentDescription = "Clear")
                            }
                        })
                    Spacer(20.dp)
                    GetTextFields(
                        title = desc,
                        placeholderText = "Enter Description",
                        maxLines = 20, minLines = 5
                    )
                    Spacer(height = 40.dp)
                    Button(
                        onClick = {
                            CoroutineScope(Dispatchers.Main).launch {
                                submitTheData(title.value, desc.value, viewModel, navController)
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp)
                    ) {

                        Text(
                            text = "Add Note ",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 5.dp)
                        )

                    }
                }
            }
        }
    }


}

private suspend fun submitTheData(
    title: String,
    desc: String,
    viewModel: DashboardViewModel,
    navController: NavController
) {

    if (title.trim().isEmpty() || desc.trim().isEmpty()) {
        return
    }

    viewModel.fireEvent(
        DataBaseEvents.UpsertDataEvent(
            NoteEntity(
                title = title,
                content = desc,
                timestamp = Date().time.milliseconds.inWholeMilliseconds
            )
        )
    )
    viewModel.events.collect {
        if (it !is ResponseManager.OnSuccess) {
            return@collect
        }

        navController.popBackStack()
    }

}
