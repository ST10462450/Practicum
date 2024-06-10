package com.example.myweather

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class initialSplash() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<initialSplash> {
        override fun createFromParcel(parcel: Parcel): initialSplash {
            return initialSplash(parcel)
        }

        override fun newArray(size: Int): Array<initialSplash?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initial_splash)

        Handler(Looper.getMainLooper()).postDelayed(
            {
                startActivity(Intent(this, SplashActivity::class.java))
                finish()
            }, 3000
        )
    }
}
