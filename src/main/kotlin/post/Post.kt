package post

import post.PostType.*

data class Post(
    val fromId : Int,
    val ownerId : Int = 0,
    val text : String = "",
    val id : Int = 0,
    val date : Int = 0,
    val friendsOnly : Boolean = false,
    val likes : Likes = Likes(),
    val reposts : Reposts = Reposts(),
    val views : Views = Views(),
    val postType : PostType = POST,
    val signerId : Int = 0,
    val canPin : Boolean = false,
    val canDelete : Boolean = false,
    val canEdit : Boolean = false,
    val isPinned : Boolean = false,
    val markedAsAds : Boolean = false,
    val isFavorite : Boolean = false,
    val postponedId : Int = 0,
    val attachments : Array<Attachment> = emptyArray()
) {

    val createdBy : Int? = null
    val replyOwnerId : Int? = null
    val replyPostId : Int? = null
    val copyright : Copyright? = null
    val donut : PostDonat? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Post
        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return id
    }
}