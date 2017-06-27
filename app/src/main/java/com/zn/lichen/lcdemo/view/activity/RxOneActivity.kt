package com.zn.lichen.lcdemo.view.activity

import android.content.Intent
import android.os.Bundle
import butterknife.ButterKnife
import com.zn.lichen.framework.base.BaseActivity
import com.zn.lichen.lcdemo.R
import com.zn.lichen.lcdemo.widget.Titanic
import com.zn.lichen.lcdemo.widget.TitanicTextView
import com.zn.lichen.lcdemo.widget.Typefaces
import kotlinx.android.synthetic.main.activity_rx_one.*
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

/**
 * Created by lichen on 2017/2/16.
 */
class RxOneActivity : BaseActivity() {


    override fun listReceiveActions(): Array<String> {
        return arrayOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_one)
        ButterKnife.bind(this)
        initView()
    }

    private fun initView() {
        getAuthCode.setOnClickListener {
            //                startTimer();
            startActivity(Intent(this@RxOneActivity, KotlinActivity::class.java))
            finish()
        }

        val tv = findViewById(R.id.my_text_view) as TitanicTextView

        // set fancy typeface
        tv.typeface = Typefaces.get(this, "Satisfy-Regular.ttf")

        // start animation
        Titanic().start(tv)

//        tv.setOnClickListener { Intent(this@RxOneActivity,PersonInfoActivity::class.java) }

    }

    private fun startTimer() {
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(60)
                .map { second -> 59 - second!! }
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<Long>() {
                    override fun onCompleted() {
                        getAuthCode.text = "获取验证码"
                        startActivity(Intent(this@RxOneActivity, KotlinActivity::class.java))
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onNext(aLong: Long?) {
                        getAuthCode.text = aLong!!.toString() + "s"
                    }
                })
    }
}
