package com.jeongdaeri.secondclassproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    val TAG: String = "로그"

    var myInterface: MyInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // 데이터 받는 방법
        val receivedData = intent.extras?.get("data") as String

        Log.d(TAG, "SecondActivity - onCreate() called / receivedData: $receivedData")

        interface_check_btn.setOnClickListener {

            myInterface?.didClick()

        }

    }
}
