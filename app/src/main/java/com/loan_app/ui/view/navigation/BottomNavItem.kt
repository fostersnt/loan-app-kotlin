package com.loan_app.ui.view.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.loan_app.data.model.AppRoutes

data class BottomNavItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
    val indexValue: Int
)

object BottomNavItems {
    val list = listOf(
        BottomNavItem(
            title = "Home",
            icon = Icons.Filled.Home,
            route = AppRoutes.HOME_SCREEN,
            indexValue = 0
        ),
        BottomNavItem(
            title = "Profile",
            icon = Icons.Filled.Person,
            route = AppRoutes.PROFILE_SCREEN,
                    indexValue = 1
        ),
        BottomNavItem(
            title = "Settings",
            icon = Icons.Filled.Settings,
            route = AppRoutes.SETTINGS_SCREEN,
                    indexValue = 2
        )
    )
}
