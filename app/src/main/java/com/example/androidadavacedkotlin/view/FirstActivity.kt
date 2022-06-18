package com.example.androidadavacedkotlin.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import br.com.simplepass.loadingbutton.animatedDrawables.ProgressType
import br.com.simplepass.loadingbutton.customViews.CircularProgressButton
import br.com.simplepass.loadingbutton.customViews.ProgressButton
import com.example.androidadavacedkotlin.R
import timber.log.Timber
import java.util.*


class FirstActivity : AppCompatActivity() {
    private var btn_en: Button? = null
    private var btn_jp: Button? = null
    private var btn_kr: Button? = null
    private var btn_ru: Button? = null
    private var btn_uz: Button? = null
    private var btn_cn: Button? = null
    private var buttonTest10: CircularProgressButton? = null
    private var buttonTest9: CircularProgressButton? = null
    private var tv_desc: TextView? = null

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        Timber.plant(Timber.DebugTree())
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
            Timber.i("click korean ")
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
            Timber.w("Click China")
        }
        tv_desc = findViewById(R.id.tv_desc)
        buttonTest10 = findViewById(R.id.btn_check_first)
        buttonTest10?.run { setOnClickListener { morphDoneAndRevert(this@FirstActivity) } }

        buttonTest9 = findViewById(R.id.btn_check_second)
        buttonTest9?.run {
            setOnClickListener {
                morphAndRevert {
                    Toast.makeText(
                        this@FirstActivity, "Yahooo",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
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

    private fun defaultColor(context: Context) =
        ContextCompat.getColor(context, android.R.color.darker_gray)

    private fun defaultDoneImage(resources: Resources) =
        BitmapFactory.decodeResource(resources, R.drawable.done_black)

    private fun ProgressButton.morphDoneAndRevert(
        context: Context,
        fillColor: Int = defaultColor(context),
        bitmap: Bitmap = defaultDoneImage(context.resources),
        doneTime: Long = 3000,
        revertTime: Long = 4000
    ) {
        progressType = ProgressType.INDETERMINATE
        startAnimation()
        Handler().run {
            postDelayed({ doneLoadingAnimation(fillColor, bitmap) }, doneTime)
            postDelayed(::revertAnimation, revertTime)
        }
    }

    private fun ProgressButton.morphAndRevert(
        revertTime: Long = 3000,
        startAnimationCallback: () -> Unit = {}
    ) {
        startAnimation(startAnimationCallback)
        Handler().postDelayed(::revertAnimation, revertTime)
    }

}