package com.example.hiltl

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class SomeClass @Inject constructor(private val someOtherclass:SomeOtherClass) {
    fun doAThing(): String {
        return "Look I did a thing!"
    }
    fun doAnotherThing():String{
        return someOtherclass.doSomeOtherThing();
    }
}

class SomeOtherClass @Inject constructor() {
    fun doSomeOtherThing(): String {
        return "Some other thing"
    }
}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        println(someClass.doAThing())
        println(someClass.doAnotherThing())
    }
}
