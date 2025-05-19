package com.loan_app.ui.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.loan_app.R
import com.loan_app.data.model.AppColors
import com.loan_app.data.model.AppRoutes
import com.loan_app.utilities.customFontFamily

private val cardImages = listOf(
    R.drawable.card_1_image,
    R.drawable.card_2_image,
    R.drawable.card_3_image
)

@Composable
fun HomeScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(AppColors.BACKGROUND_COLOR),
            darkIcons = false // Set to true if background is light
        )
    }

    val myCustomFontFamily = customFontFamily()
    LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Quick Actions",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    QuickActionCard(navController, "Apply", AppRoutes.LOAN_REQUEST_SCREEN, cardImages[0])
                    QuickActionCard(navController, "History", AppRoutes.LOAN_HISTORY_SCREEN, cardImages[1])
                    QuickActionCard(navController, "Account", AppRoutes.TEST_SCREEN, cardImages[2])
                }
            }
        }
}

@Composable
fun QuickActionCard(
    navController: NavController,
    label: String,
    route: String,
    iconRes: Int
) {

    Card(
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(AppColors.WHITE_COLOR)
        ),
        onClick = {navController.navigate(route)}
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(8.dp)
                .width(100.dp)
                .height(130.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .aspectRatio(1f)
            )
            Text(
                text = label,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black
            )
        }
    }
}
