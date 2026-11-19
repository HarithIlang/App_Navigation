package com.example.app_navigation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_navigation.data.Datasource
import com.example.app_navigation.R
import com.example.app_navigation.model.Team
import com.example.app_navigation.ui.theme.App_NavigationTheme

// The Home page: a title, the scrolling list of teams, and the contact button at the bottom.
@Composable
fun HomeScreen(onContactClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = stringResource(R.string.home_title),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 8.dp)
        )
        // weight(1f) = "take all the leftover space", so the button below stays at the bottom
        TeamList(
            teamList = Datasource().loadTeams(),
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = onContactClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp)
        ) {
            Text(
                text = stringResource(R.string.go_to_contact),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

// The scrolling list: draws one TeamCard for each team in the list.
@Composable
fun TeamList(teamList: List<Team>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(teamList) { team ->
            TeamCard(team = team, modifier = Modifier.padding(8.dp))
        }
    }
}

// One row of the list: the team's logo with its name under it.
@Composable
fun TeamCard(team: Team, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(team.imageResourceId),
                contentDescription = stringResource(team.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(top = 8.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(team.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    App_NavigationTheme {
        HomeScreen(onContactClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun TeamCardPreview() {
    App_NavigationTheme {
        TeamCard(team = Team(R.string.team1, R.drawable.image1))
    }
}
