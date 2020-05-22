package com.jeongdaeri.secondclassproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.jeongdaeri.secondclassproject.Constants.SECOND_ACTIVITY
import com.jeongdaeri.secondclassproject.Constants.TAG
import com.jeongdaeri.secondclassproject.Constants.THIRD_ACTIVITY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, MyInterface {


    val TAG = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 클릭 리스너를 설정해준다. - 즉 자기 자신 클릭리스너를 지칭
        next_btn.setOnClickListener(this)
        next_with_result_btn.setOnClickListener(this)

        third_btn.setOnClickListener {



            Log.d(TAG, "MainActivity - 세번째 버튼이 클릭되었다.")

            val intent = Intent(this, ThirdActivity::class.java)

            intent.putExtra("data", "호호호")



            startActivityForResult(intent, THIRD_ACTIVITY)
        }


    }

    override fun onClick(view: View?) {

        Log.d(TAG, "MainActivity - onClick() called / view.id : $view.id")

        when(view?.id){

            next_btn.id -> {
                Log.d(TAG, "MainActivity - 다음버튼이 클릭되었다.")
                val intent = Intent(this, SecondActivity::class.java)

                intent.putExtra("data", "안녕하세요?!")

                startActivity(intent)
            }
            next_with_result_btn.id -> {
                Log.d(TAG, "MainActivity - 일반버튼이 클릭되었다.")
                val intent = Intent(this, SecondActivity::class.java)

                intent.putExtra("data", "안녕하세요?!")

                startActivityForResult(intent, SECOND_ACTIVITY)
            }

//            third_btn.id -> {
//                Log.d(TAG, "MainActivity - 세번째 버튼이 클릭되었다.")
//                val intent = Intent(this, ThirdActivity::class.java)
//
//                intent.putExtra("data", "호호호")
//
//                startActivityForResult(intent, THIRD_ACTIVITY)
//            }


        }

    }

    // 부메랑 같은 것
    // 리퀘스트 코드 - 누구한테 보냈다.
    // 리졸트 코드 - 결과
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d(TAG, "MainActivity - onActivityResult() called / resultCode: $resultCode / data : ${data?.extras?.get("sendBack")}")


        if(requestCode == SECOND_ACTIVITY){

        } else if (requestCode == THIRD_ACTIVITY){

        }

        when(requestCode){

            SECOND_ACTIVITY -> {
                Log.d(TAG, "MainActivity - 쎄컨드 액티비티가 종료됨")
            }

            THIRD_ACTIVITY -> {
                Log.d(TAG, "MainActivity - 써드 액티비티가 종료됨 data: ${data?.extras?.get("sendBack")}")

            }

        }

    }

    // MyInterface 메소드
    override fun didClick() {
        Log.d(TAG, "MainActivity - didClick() called")
    }


}
