package com.example.sns_project

import java.io.Serializable

data class User(
    val uuid : String,
    val userid : String,
    val userpw : String,
    val useremail : String,
    val username : String
): Serializable

data class SignupNameModel(
    var UserName: String
)
data class SignupNameResult(
    var message: Boolean
)
data class SignupModel(
    var id: String,
    var pw: String,
    var name: String,
    var email: String
)

data class SignupResult(
    var message: Boolean
)
