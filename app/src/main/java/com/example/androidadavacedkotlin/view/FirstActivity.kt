package com.example.androidadavacedkotlin.view

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidadavacedkotlin.R
import java.util.*


class FirstActivity : AppCompatActivity() {
    private var btn_en: Button? = null
    private var btn_jp: Button? = null
    private var btn_kr: Button? = null
    private var btn_ru: Button? = null
    private var btn_uz: Button? = null
    private var btn_cn: Button? = null
    private var tv_desc: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        btn_en = findViewById(R.id.btn_en)
        btn_en?.setOnClickListener {
            setLocale("en")
        }
        btn_jp = findViewById(R.id.btn_jp)
        btn_jp?.setOnClickListener {
            setLocale("ja")
        }
        btn_kr = findViewById(R.id.btn_kr)
        btn_kr?.setOnClickListener {
            setLocale("ko")
        }
        btn_ru = findViewById(R.id.btn_ru)
        btn_ru?.setOnClickListener {
            setLocale("ru");
        }
        btn_uz = findViewById(R.id.btn_uz)
        btn_uz?.setOnClickListener {
            setLocale("uz")
        }
        btn_cn = findViewById(R.id.btn_cn)
        btn_cn?.setOnClickListener {
            setLocale("zh")
        }
        tv_desc = findViewById(R.id.tv_desc)
    }

    private fun setLocale(lan: String) {
        val locale = Locale(lan)
        Locale.setDefault(locale)
        val config: Configuration = baseContext.resources.configuration
        config.locale = locale
        baseContext.resources.updateConfiguration(
            config,
            baseContext.resources.displayMetrics
        )
        finish()
    }
}