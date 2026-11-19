package com.example.app_navigation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_navigation.R
import com.example.app_navigation.ui.theme.App_NavigationTheme

// The Contact page: a picture and the creator's contact info, like a business card.
@Composable
fun ContactScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            // lets the page scroll when the phone is sideways and it doesn't fit
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.csi_horizontal),
            contentDescription = stringResource(R.string.contact_school),
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        Text(
            text = stringResource(R.string.contact_name),
            modifier = Modifier.padding(top = 16.dp),
            style = MaterialTheme.typography.headlineMedium
        )
        Text(text = stringResource(R.string.contact_role))
        Text(text = stringResource(R.string.contact_school))
        Text(
            text = stringResource(R.string.contact_email),
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(text = stringResource(R.string.contact_phone))
    }
}

@Preview(showBackground = true)
@Composable
fun ContactScreenPreview() {
    App_NavigationTheme {
        ContactScreen()
    }
}
