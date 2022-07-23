package com.codesoft.whatsapp.model

data class MessageModel(
    var message : String? = "",
    var senderId : String ? = "",
    var timeStemp : Long? = 0
)
