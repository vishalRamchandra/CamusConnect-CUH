package com.example.campusconnect.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.ChatBubble
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Assignment
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.campusconnect.ui.theme.PrimaryRose
import com.example.campusconnect.ui.theme.TextMuted

enum class NavTab {
    HOME,
    MESSAGES,
    PROFILE,
    NOTICE_BOARD
}

@Composable
fun BottomNavBar(
    selectedTab: NavTab,
    unreadMessagesCount: Int = 3,
    onTabSelected: (NavTab) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shadowElevation = 8.dp,
        color = Color.White,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavItem(
                tab = NavTab.HOME,
                selected = selectedTab == NavTab.HOME,
                label = "Home",
                activeIcon = Icons.Filled.Home,
                inactiveIcon = Icons.Outlined.Home,
                onSelect = { onTabSelected(NavTab.HOME) }
            )

            NavItem(
                tab = NavTab.MESSAGES,
                selected = selectedTab == NavTab.MESSAGES,
                label = "Messages",
                activeIcon = Icons.Filled.ChatBubble,
                inactiveIcon = Icons.Outlined.ChatBubbleOutline,
                badgeCount = unreadMessagesCount,
                onSelect = { onTabSelected(NavTab.MESSAGES) }
            )

            NavItem(
                tab = NavTab.PROFILE,
                selected = selectedTab == NavTab.PROFILE,
                label = "Profile",
                activeIcon = Icons.Filled.Person,
                inactiveIcon = Icons.Outlined.Person,
                onSelect = { onTabSelected(NavTab.PROFILE) }
            )

            NavItem(
                tab = NavTab.NOTICE_BOARD,
                selected = selectedTab == NavTab.NOTICE_BOARD,
                label = "Notice Board",
                activeIcon = Icons.Filled.Assignment,
                inactiveIcon = Icons.Outlined.Assignment,
                onSelect = { onTabSelected(NavTab.NOTICE_BOARD) }
            )
        }
    }
}

@Composable
private fun NavItem(
    tab: NavTab,
    selected: Boolean,
    label: String,
    activeIcon: ImageVector,
    inactiveIcon: ImageVector,
    badgeCount: Int = 0,
    onSelect: () -> Unit
) {
    val activeColor = PrimaryRose
    val inactiveColor = TextMuted

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 4.dp)
            .clickable { onSelect() }
    ) {
        Box(contentAlignment = Alignment.TopEnd) {
            Icon(
                imageVector = if (selected) activeIcon else inactiveIcon,
                contentDescription = label,
                tint = if (selected) activeColor else inactiveColor,
                modifier = Modifier.size(26.dp)
            )

            if (badgeCount > 0) {
                Box(
                    modifier = Modifier
                        .offset(x = 6.dp, y = (-2).dp)
                        .size(14.dp)
                        .background(PrimaryRose, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = badgeCount.toString(),
                        color = Color.White,
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(3.dp))

        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = if (selected) activeColor else inactiveColor,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
        )
    }
}
