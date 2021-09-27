package com.example.studyapp

class Materials(private var title:String,private var shortDescription:String,private var longDescription:String) {
    fun getTitle():String{
        return title
    }
    fun getShortDescription():String{
        return shortDescription
    }
    fun getLongDescription():String{
        return longDescription
    }
}