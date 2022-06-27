package post

import content.*

sealed interface Attachment {
    val type : String
}

class AudioAttachment(val audio : Audio, override val type: String = "Audio") : Attachment

class FileAttachment(val file : File, override val type: String = "File") : Attachment

class GraffitiAttachment(val graffiti: Graffiti, override val type: String = "Graffiti") : Attachment

class PhotoAttachment(val photo : Photo, override val type: String = "Photo") : Attachment

class VideoAttachment(val video: Video, override val type: String = "Video") : Attachment

