package com.example.campusconnect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.campusconnect.data.ChatConversation
import com.example.campusconnect.data.ChatMessage
import com.example.campusconnect.data.MockData
import com.example.campusconnect.data.NoticeItem
import com.example.campusconnect.data.PostItem
import com.example.campusconnect.data.UserProfile
import com.example.campusconnect.ui.components.BottomNavBar
import com.example.campusconnect.ui.components.NavTab
import com.example.campusconnect.ui.screens.*
import com.example.campusconnect.ui.theme.CampusConnectTheme

enum class AppScreen {
    SIGN_UP,
    SIGN_IN,
    MAIN_APP
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusConnectTheme {
                CampusConnectApp()
            }
        }
    }
}

@Composable
fun CampusConnectApp() {
    var currentUser by remember { mutableStateOf<UserProfile?>(MockData.defaultUser) }
    var currentScreen by remember { mutableStateOf(AppScreen.MAIN_APP) }
    var selectedTab by remember { mutableStateOf(NavTab.HOME) }
    var selectedChat by remember { mutableStateOf<ChatConversation?>(null) }

    // State data stores
    val postsList = remember { mutableStateListOf(*MockData.getInitialPosts().toTypedArray()) }
    val noticesList = remember { mutableStateListOf(*MockData.getInitialNotices().toTypedArray()) }
    val conversationsList = remember { mutableStateListOf(*MockData.getInitialConversations().toTypedArray()) }

    val unreadMessagesCount = conversationsList.sumOf { it.unreadCount }

    Box(modifier = Modifier.fillMaxSize()) {
        Crossfade(targetState = currentScreen, label = "ScreenTransition") { screen ->
            when (screen) {
                AppScreen.SIGN_UP -> {
                    SignUpScreen(
                        onSignUpSuccess = { newUser ->
                            currentUser = newUser
                            currentScreen = AppScreen.MAIN_APP
                            selectedTab = NavTab.HOME
                        },
                        onNavigateToSignIn = {
                            currentScreen = AppScreen.SIGN_IN
                        }
                    )
                }

                AppScreen.SIGN_IN -> {
                    SignInScreen(
                        onSignInSuccess = { user ->
                            currentUser = user
                            currentScreen = AppScreen.MAIN_APP
                            selectedTab = NavTab.HOME
                        },
                        onNavigateToSignUp = {
                            currentScreen = AppScreen.SIGN_UP
                        }
                    )
                }

                AppScreen.MAIN_APP -> {
                    val user = currentUser ?: MockData.defaultUser

                    if (selectedChat != null) {
                        // Chat Detail View
                        ChatDetailScreen(
                            conversation = selectedChat!!,
                            onBack = { selectedChat = null },
                            onSendMessage = { text ->
                                val updatedChat = selectedChat!!.copy(
                                    lastMessage = "You: $text",
                                    timeAgo = "Just now",
                                    messages = selectedChat!!.messages + ChatMessage(
                                        id = "msg_${System.currentTimeMillis()}",
                                        senderName = user.fullName,
                                        text = text,
                                        time = "Just now",
                                        isFromMe = true
                                    )
                                )
                                selectedChat = updatedChat
                                val index = conversationsList.indexOfFirst { it.id == updatedChat.id }
                                if (index != -1) {
                                    conversationsList[index] = updatedChat
                                }
                            }
                        )
                    } else {
                        // Main Bottom Navigation Flow
                        Scaffold(
                            bottomBar = {
                                BottomNavBar(
                                    selectedTab = selectedTab,
                                    unreadMessagesCount = unreadMessagesCount,
                                    onTabSelected = { tab ->
                                        selectedTab = tab
                                    }
                                )
                            }
                        ) { innerPadding ->
                            Box(modifier = Modifier.padding(innerPadding)) {
                                when (selectedTab) {
                                    NavTab.HOME -> {
                                        HomeScreen(
                                            user = user,
                                            posts = postsList,
                                            onToggleLike = { postId ->
                                                val index = postsList.indexOfFirst { it.id == postId }
                                                if (index != -1) {
                                                    val item = postsList[index]
                                                    val isLikedNew = !item.isLiked
                                                    val countNew = if (isLikedNew) item.likesCount + 1 else item.likesCount - 1
                                                    postsList[index] = item.copy(isLiked = isLikedNew, likesCount = countNew)
                                                }
                                            },
                                            onToggleBookmark = { postId ->
                                                val index = postsList.indexOfFirst { it.id == postId }
                                                if (index != -1) {
                                                    val item = postsList[index]
                                                    postsList[index] = item.copy(isBookmarked = !item.isBookmarked)
                                                }
                                            },
                                            onAddPost = { newPost ->
                                                postsList.add(0, newPost)
                                            }
                                        )
                                    }

                                    NavTab.MESSAGES -> {
                                        MessagesScreen(
                                            conversations = conversationsList,
                                            onSelectConversation = { chat ->
                                                // Clear unread count when opened
                                                val index = conversationsList.indexOfFirst { it.id == chat.id }
                                                if (index != -1) {
                                                    conversationsList[index] = conversationsList[index].copy(unreadCount = 0)
                                                }
                                                selectedChat = chat.copy(unreadCount = 0)
                                            }
                                        )
                                    }

                                    NavTab.PROFILE -> {
                                        ProfileScreen(
                                            user = user,
                                            onUpdateUser = { updatedUser ->
                                                currentUser = updatedUser
                                            },
                                            onSignOut = {
                                                currentUser = null
                                                currentScreen = AppScreen.SIGN_IN
                                                selectedChat = null
                                            }
                                        )
                                    }

                                    NavTab.NOTICE_BOARD -> {
                                        NoticeBoardScreen(
                                            user = user,
                                            notices = noticesList,
                                            onToggleBookmark = { noticeId ->
                                                val index = noticesList.indexOfFirst { it.id == noticeId }
                                                if (index != -1) {
                                                    val item = noticesList[index]
                                                    noticesList[index] = item.copy(isBookmarked = !item.isBookmarked)
                                                }
                                            },
                                            onAddNotice = { newNotice ->
                                                noticesList.add(0, newNotice)
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
