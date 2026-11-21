package com.example.campusconnect.data

enum class UserRole {
    STUDENT,
    FACULTY
}

data class UserProfile(
    val fullName: String,
    val email: String,
    val department: String,
    val role: UserRole,
    val rollNo: String = "",
    val username: String = "@" + email.substringBefore("@").lowercase(),
    val bio: String = "Learning, innovating & connecting at Central University of Haryana.",
    val campus: String = "Central University of Haryana",
    val postsCount: Int = 24,
    val followersCount: Int = 348,
    val followingCount: Int = 216
)

data class PostItem(
    val id: String,
    val authorName: String,
    val authorHandle: String = "",
    val locationAndTime: String,
    val text: String,
    val imageResType: String? = null,
    val isVideo: Boolean = false,
    val videoDuration: String? = null,
    var likesCount: Int,
    var isLiked: Boolean = false,
    var commentsCount: Int,
    var isBookmarked: Boolean = false,
    val isFollowing: Boolean = true
)

data class ChatConversation(
    val id: String,
    val name: String,
    val lastMessage: String,
    val timeAgo: String,
    val unreadCount: Int = 0,
    val avatarColorIndex: Int = 0,
    val messages: List<ChatMessage> = emptyList()
)

data class ChatMessage(
    val id: String,
    val senderName: String,
    val text: String,
    val time: String,
    val isFromMe: Boolean
)

enum class NoticeCategory {
    EVENT,
    DOCUMENT,
    UPDATE
}

data class NoticeItem(
    val id: String,
    val authorName: String,
    val authorRole: String,
    val timeAgo: String,
    val category: NoticeCategory,
    val title: String,
    val description: String,
    val extraInfo: String? = null,
    val fileName: String? = null,
    val fileSize: String? = null,
    var repliesCount: Int = 0,
    var isBookmarked: Boolean = false
)
