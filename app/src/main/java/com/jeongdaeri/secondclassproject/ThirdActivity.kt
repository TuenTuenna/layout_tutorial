package com.jeongdaeri.secondclassproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class ThirdActivity : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        Log.d(TAG, "ThirdActivity - onCreate() called")


    }


    fun onDoneBtnClicked(view: View){
        Log.d(TAG, "ThirdActivity - onDoneBtnClicked() called")

        val result = Intent()
        result.putExtra("sendBack", "완료버튼이 클릭되었다!")
        setResult(Activity.RESULT_OK, result)

        finish()
    }


    override fun onBackPressed() {
        super.onBackPressed()
        Log.d(TAG, "ThirdActivity - onBackPressed() called")
    }

}
