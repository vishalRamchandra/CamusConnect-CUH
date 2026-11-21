package com.example.campusconnect.data

object MockData {

    val defaultUser = UserProfile(
        fullName = "Ananya Sharma",
        email = "ananya.sharma@cuh.ac.in",
        department = "Computer Science & Engineering",
        role = UserRole.STUDENT,
        rollNo = "210945-CSE",
        username = "@ananyasharma",
        bio = "Computer Science student at CUH. Tech enthusiast, coder & campus lead.",
        campus = "Central University of Haryana",
        postsCount = 24,
        followersCount = 348,
        followingCount = 216
    )

    fun getInitialConversations(): List<ChatConversation> {
        return listOf(
            ChatConversation(
                id = "1",
                name = "Dr. Rajesh Kumar",
                lastMessage = "Lab manuals uploaded on portal. 📚",
                timeAgo = "2m",
                unreadCount = 2,
                avatarColorIndex = 0,
                messages = listOf(
                    ChatMessage("m1", "Dr. Rajesh Kumar", "Hello Ananya, did you check the lab assignment for CSE302?", "2:14 PM", false),
                    ChatMessage("m2", "Dr. Rajesh Kumar", "Lab manuals uploaded on portal. 📚", "2:15 PM", false)
                )
            ),
            ChatConversation(
                id = "2",
                name = "Priyanshu Sharma",
                lastMessage = "Cafeteria meet for hackathon prep?",
                timeAgo = "14m",
                unreadCount = 1,
                avatarColorIndex = 1,
                messages = listOf(
                    ChatMessage("m3", "Priyanshu Sharma", "Hey Ananya! Are you joining the Tech Fest team?", "2:01 PM", false),
                    ChatMessage("m4", "Priyanshu Sharma", "Cafeteria meet for hackathon prep?", "2:02 PM", false)
                )
            ),
            ChatConversation(
                id = "3",
                name = "Rahul Verma",
                lastMessage = "You: Thanks! Got the notes.",
                timeAgo = "38m",
                unreadCount = 0,
                avatarColorIndex = 2,
                messages = listOf(
                    ChatMessage("m5", "Rahul Verma", "Sent you the Data Structures lecture notes.", "1:35 PM", false),
                    ChatMessage("m6", "You", "Thanks! Got the notes.", "1:38 PM", true)
                )
            ),
            ChatConversation(
                id = "4",
                name = "Sneha Yadav",
                lastMessage = "Library main hall seats reserved :)",
                timeAgo = "1h",
                unreadCount = 0,
                avatarColorIndex = 3,
                messages = listOf(
                    ChatMessage("m7", "Sneha Yadav", "Library main hall seats reserved :)", "1:15 PM", false)
                )
            ),
            ChatConversation(
                id = "5",
                name = "Dr. Sunita Sharma",
                lastMessage = "You: Submitted the project proposal.",
                timeAgo = "2h",
                unreadCount = 0,
                avatarColorIndex = 4,
                messages = listOf(
                    ChatMessage("m8", "Dr. Sunita Sharma", "Please submit your research proposal by 5 PM.", "12:10 PM", false),
                    ChatMessage("m9", "You", "Submitted the project proposal.", "12:12 PM", true)
                )
            ),
            ChatConversation(
                id = "6",
                name = "Aman Gupta",
                lastMessage = "CUH Sports meet registration is live!",
                timeAgo = "3h",
                unreadCount = 0,
                avatarColorIndex = 5,
                messages = listOf(
                    ChatMessage("m10", "Aman Gupta", "CUH Sports meet registration is live!", "11:05 AM", false)
                )
            )
        )
    }

    fun getInitialPosts(): List<PostItem> {
        return listOf(
            PostItem(
                id = "p1",
                authorName = "Priyanshu Sharma",
                authorHandle = "@priyanshu_cuh",
                locationAndTime = "CUH Academic Block · 18 min ago",
                text = "Sunny afternoon at CUH Academic Lawn! Preps in full swing for the upcoming Technical Fest ☀️🎓",
                imageResType = "picnic",
                likesCount = 142,
                commentsCount = 18,
                isLiked = false,
                isBookmarked = false
            ),
            PostItem(
                id = "p2",
                authorName = "Rahul Verma",
                authorHandle = "@rahulv_cuh",
                locationAndTime = "CUH Auditorium · 42 min ago",
                text = "Annual Cultural Fest Performances practice at CUH Auditorium! 🎶🎭",
                imageResType = "music",
                isVideo = true,
                videoDuration = "0:30",
                likesCount = 98,
                commentsCount = 12,
                isLiked = true,
                isBookmarked = true
            ),
            PostItem(
                id = "p3",
                authorName = "Dr. Rajesh Kumar",
                authorHandle = "@dr_rajesh_cuh",
                locationAndTime = "CSE Department · 2 hours ago",
                text = "Guest Lecture on Artificial Intelligence and Machine Learning tomorrow in Seminar Hall 1 at 11 AM. All students are invited! 💻🤖",
                imageResType = "library",
                likesCount = 76,
                commentsCount = 9,
                isLiked = false,
                isBookmarked = false
            )
        )
    }

    fun getInitialNotices(): List<NoticeItem> {
        return listOf(
            NoticeItem(
                id = "n1",
                authorName = "Dr. Sunita Sharma",
                authorRole = "Faculty & Dean Academics",
                timeAgo = "32 min ago",
                category = NoticeCategory.EVENT,
                title = "CUH Annual Inter-Departmental Sports Meet 2025",
                description = "Registrations are open for Cricket, Badminton, Athletics, and Chess. Form submission at Sports Complex Office.",
                extraInfo = "Starts Next Monday, 9:00 AM · CUH Sports Complex",
                repliesCount = 24
            ),
            NoticeItem(
                id = "n2",
                authorName = "Dr. Rajesh Kumar",
                authorRole = "HOD Computer Science",
                timeAgo = "1 hour ago",
                category = NoticeCategory.DOCUMENT,
                title = "Mid_Semester_Exam_Schedule_CSE.pdf",
                description = "Official timetable for Mid-Semester Examinations for B.Tech & M.Tech Computer Science & Engineering.",
                fileName = "Mid_Semester_Exam_Schedule_CSE.pdf",
                fileSize = "PDF document · 3 pages · 1.4 MB",
                repliesCount = 6
            ),
            NoticeItem(
                id = "n3",
                authorName = "Ananya Sharma",
                authorRole = "Student Council Lead",
                timeAgo = "2 hours ago",
                category = NoticeCategory.UPDATE,
                title = "Central Library Extended Hours During Exams",
                description = "CUH Central Library will remain open till 11:00 PM starting this week for exam preparation.",
                repliesCount = 12
            )
        )
    }
}
