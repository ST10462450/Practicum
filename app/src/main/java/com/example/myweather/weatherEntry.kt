package com.example.myweather

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Size
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.FormattableFlags

data class weatherEntry(
    val day : String, // day recorded
    val min : Double, // minimum temperature
    val max : Double, // maximum temperature
    val condition : String // describing the days condition
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString() ?:"",
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString() ?:""
    )
// method to write the weather entries to a parcel , a parcel is used to transfer data between activities
    override fun writeToParcel(parcel : Parcel, flags: Int){
        parcel.writeString(day)
        parcel.writeDouble(min)
        parcel.writeDouble(max)
        parcel.writeString(condition)
}
// method for describing the data
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR: Parcelable.Creator<weatherEntry>{
        override fun createFromParcel(parcel: Parcel): weatherEntry{
            return weatherEntry(parcel)
        }

        override fun newArray(size: Int): Array<weatherEntry?> {
            return arrayOfNulls(size)
        }
    }
}