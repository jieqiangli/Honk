package org.fuzz.honk

import android.app.Activity
import android.media.SoundPool
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity() {

    private var soundPool = SoundPool.Builder()
        .setMaxStreams(10)
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val honk1 = soundPool.load(this, R.raw.honk1, 1)
        val honk2 = soundPool.load(this, R.raw.honk2, 1)

        honk.setOnClickListener {
            if (Math.random() > 0.2) {
                doHonk(honk1)
            } else {
                doHonk(honk2)
            }
        }
    }

    private fun doHonk(id : Int) {
        soundPool.play(id, 1.0f, 1.0f, 0, 0, 1.0f)
    }

}
