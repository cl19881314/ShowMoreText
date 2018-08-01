package com.example.showmoretext

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var des ="\u3000\u3000" + "测试大多数快点哈爱是客观测。\n试大多数快点哈爱是客观测试大多数快点哈爱是客观测试大多数快点哈爱是客观测试大多数快点哈爱是客观测试大多数快点哈爱是客观测试大多数快点哈爱是客观测试大多数快点哈爱是客观测试大多数快点哈爱是客观测试大多数快点哈爱是客观测试大多数快点哈爱是客观测试大多数快点哈爱是客观"
//        var des = "我们你们他维克拉我家"
        txtShowContent.setDesc(des)
    }
}
