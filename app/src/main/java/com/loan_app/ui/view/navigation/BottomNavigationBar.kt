package com.loan_app.ui.view.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.loan_app.data.model.AppColors

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val startDestination = BottomNavItems.list[0];
    var selectedDestination = rememberSaveable { mutableIntStateOf(startDestination.indexValue) }

    Scaffold(
        modifier = modifier,
        bottomBar = {
            CustomBottomNavBar(
                selectedIndex = selectedDestination.intValue,
                onItemSelected = { index ->
                    navController.navigate(BottomNavItems.list[index].route)
                    selectedDestination.intValue = index
                }
            )
//            NavigationBar(
//                windowInsets = NavigationBarDefaults.windowInsets,
//                containerColor = Color(AppColors.WHITE_COLOR),
//            ) {
//                BottomNavItems.list.forEachIndexed { index, destination ->
//                    NavigationBarItem(
//                        modifier = Modifier.height(80.dp),
//                        selected = selectedDestination.intValue == index,
//                        onClick = {
//                            navController.navigate(route = destination.route)
//                            selectedDestination.intValue = index
//                        },
//                        icon = {
//                            Icon(
//                                destination.icon,
//                                contentDescription = destination.title
//                            )
//                        },
//                        label = { Text(destination.title) }
//                    )
//                }
//            }
        }
    ) { contentPadding ->
        NavigationGraph(navController, contentPadding)
    }
}

@Composable
fun CustomBottomNavBar(
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color(AppColors.WHITE_COLOR)),
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(50.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color(AppColors.WHITE_COLOR)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomNavItems.list.forEachIndexed { index, item ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        //                    .padding(bottom = 40.dp)
                        .clickable() { onItemSelected(index) }
                ) {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = if (selectedIndex == index) Color.Blue else Color.Gray
                    )
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.labelSmall,
                        color = if (selectedIndex == index) Color.Blue else Color.Gray,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}
