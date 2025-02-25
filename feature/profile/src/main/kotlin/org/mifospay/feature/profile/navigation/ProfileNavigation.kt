package org.mifospay.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import org.mifospay.feature.profile.ProfileRoute

const val PROFILE_ROUTE = "profile_route"

fun NavController.navigateToProfile(navOptions: NavOptions) = navigate(PROFILE_ROUTE, navOptions)

fun NavGraphBuilder.profileScreen(
    onEditProfile: () -> Unit,
    onSettings: () -> Unit,
) {
    composable(route = PROFILE_ROUTE) {
        ProfileRoute(
            onEditProfile = onEditProfile,
            onSettings = onSettings
        )
    }
}
