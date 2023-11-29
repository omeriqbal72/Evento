package com.example.evento_1.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.evento_1.ui.theme.Home.HomePage
import com.example.evento_1.ui.theme.Liked.LikedPage
import com.example.evento_1.ui.theme.Post.PostPage
import com.example.evento_1.ui.theme.Profile.ProfilePage
import com.example.evento_1.ui.theme.Search.SearchPage

data class BottomNavItem(
 val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasupdate : Boolean,
    val badgecoutn: Int? = null
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav (){


    val bottomitems = listOf(
        BottomNavItem(
            title = "HomePage" ,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasupdate = false,
        ),
        BottomNavItem(
            title = "SearchPage" ,
            selectedIcon = Icons.Filled.Search,
            unselectedIcon = Icons.Outlined.Search,
            hasupdate = false,
        ),
        BottomNavItem(
            title = "PostPage" ,
            selectedIcon = Icons.Filled.Create,
            unselectedIcon = Icons.Outlined.Create,
            hasupdate = false,
        ),
        BottomNavItem(
            title = "LikedPage" ,
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            hasupdate = false,
        ),
        BottomNavItem(
            title = "ProfilePage" ,
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            hasupdate = false,
        ),
    )

    val navController = rememberNavController()
    var selecteditemIndex by rememberSaveable {
        mutableStateOf(0)

    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                bottomitems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selecteditemIndex == index ,
                        onClick = {
                                  selecteditemIndex = index
                            navController.navigate(item.title)
                                  },
                        label = {
                              Text(text = item.title)
                        },
                        alwaysShowLabel = false,

                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgecoutn != null) {
                                        Badge {
                                            Text(text = item.badgecoutn.toString())
                                        }
                                    } else if (item.hasupdate) {
                                        Badge()
                                    }

                                }
                            )

                            {
                                Icon(
                                    imageVector = if (index == selecteditemIndex)
                                    {
                                      item.selectedIcon
                                    }else item.unselectedIcon,
                                    contentDescription = item.title)
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        // Inner content of the Scaffold, including the NavHost
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = "HomePage"
            ) {
                composable("HomePage") {
                    HomePage()
                }
                composable("SearchPage") {
                    SearchPage()
                }
                composable("ProfilePage") {
                    ProfilePage()
                }
                composable("PostPage") {
                    PostPage()
                }
                composable("LikedPage") {
                    LikedPage()                }
            }
        }

    }

//    Scaffold(
//        bottomBar = {
//            NavigationBar {
//                bottomitems.forEachIndexed { index, item ->
//                    NavigationBarItem(
//                        selected = selecteditemIndex == index ,
//                        onClick = {
//                            selecteditemIndex = index
//                             //navController     },
//                        icon = { /*TODO*/ }
//                    )
//                }
//            }
//        }
//    ) {
//
//    }

//    Scaffold (
//        bottomBar = {
//            NavigationBar {
//                items.forEachIndexed{ index , item ->
//                    NavigationBarItem(
//                        selected = false,
//                        onClick = { /*TODO*/ },
//                        icon = { /*TODO*/ })
//
//                }
//            }
//        }
//    ) {
//
//    }
}
