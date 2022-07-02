package post

class Comment (
    val id : Int = 0,
    val fromId : Int = 0,
    val date : Int = 0,
    val text : String = "",
    val replyToUser : Int = 0,
    val replyToComment : Int = 0,
    val attachments : Array<Attachment> = emptyArray(),
    val parentsStack : Array<Int> = emptyArray(),
    val thread: Thread = Thread()
    ) {
    val donat : CommentDonat? = null
}

class Thread (
    val count : Int = 0,
    val items : Array<Comment> = emptyArray(),
    val canPost : Boolean = true,
    val showReplyButton : Boolean = true,
    val groupsCanPost : Boolean = false
)