package com.outerspace.compose_experiment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.outerspace.compose_experiment.ui.theme.ComposeExperimentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExperimentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    splashScreen()
                }
            }
        }
    }
}

@Composable
fun splashScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var showInfo by remember { mutableStateOf(false) }

        val shape = RoundedCornerShape(5.dp)

        TextButton(
            onClick = { showInfo = !showInfo },
            modifier = modifier.padding(top = dimensionResource(R.dimen.logo_top_padding)),
            shape = shape) {
                Image(
                    modifier = modifier,
                    painter = painterResource(R.drawable.ganesh),
                    contentDescription = stringResource(R.string.logo_description)
                )
        }
        Text(
            modifier = modifier,
            fontSize = 48.sp,
            text = stringResource(R.string.ganesh_title),
        )
        if (showInfo) {
            Text(
                modifier = modifier,
                text = stringResource(R.string.ganesh_info)
            )
        }

        Spacer(modifier = modifier.weight(1.0f))

        Row(modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(
                onClick = {},
                modifier = modifier,
            ) {
                Text(stringResource(R.string.login_button_face))
            }
            Button(
                onClick = { showInfo = !showInfo },
                modifier = modifier,
            ) {
                Text(stringResource(R.string.info_button_face))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeExperimentTheme {
        splashScreen()
    }
}