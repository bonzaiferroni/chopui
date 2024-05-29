package streetlight.app.chopui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.Navigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Scaffold(
    title: String = "Ahoy Scaffold!",
    navigator: Navigator? = null,
    modifier: Modifier = Modifier,
    floatingAction: (() -> Unit)? = null,
    fabIcon: ImageVector = Icons.Filled.Add,
    fabDescription: String = "Add",
    content: @Composable (PaddingValues) -> Unit,
) {
    val fab: @Composable () -> Unit = if (floatingAction != null) {
        {
            FloatingActionButton(onClick = floatingAction) {
                Icon(
                    fabIcon,
                    contentDescription = fabDescription
                )
            }
        }
    } else {
        { }
    }

    val navIcon: @Composable () -> Unit = if (navigator != null) {
        {
            IconButton(onClick = { navigator.pop() }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "back"
                )
            }
        }
    } else {
        { }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = navIcon
            )
        },
        floatingActionButton = fab,
        content = content,
        modifier = modifier
    )
}

@Composable
fun BoxScaffold(
    title: String = "Ahoy Scaffold!",
    navigator: Navigator? = null,
    modifier: Modifier = Modifier,
    floatingAction: (() -> Unit)? = null,
    fabIcon: ImageVector = Icons.Filled.Add,
    fabDescription: String = "Add",
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        title = title,
        navigator = navigator,
        modifier = modifier,
        floatingAction = floatingAction,
        fabIcon = fabIcon,
        fabDescription = fabDescription,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            content(it)
        }
    }
}