package com.deushdezt.labo4_pdm_00084417.activities.model

import android.os.Parcel
import android.os.Parcelable

class Movie (
    val Title: String = "N/A",
    val Year: String = "N/A",
    val Relased: String = "N/A",
    val Runtime: String = "N/A",
    val Genre: String = "N/A",
    val Director: String = "N/A",
    val Actor: String = "N/A",
    val Plot: String = "N/A",
    val Language: String = "N/A",
    val imdbRating: String = "N/A",
    val Poster: String = "N/A"

    ):Parcelable{
    constructor(parcel: Parcel) : this(
     Title =   parcel.readString(),
        Year =   parcel.readString(),
        Relased =   parcel.readString(),
        Runtime =    parcel.readString(),
        Genre =    parcel.readString(),
        Director =   parcel.readString(),
        Actor =   parcel.readString(),
        Plot =  parcel.readString(),
        Language =    parcel.readString(),
        imdbRating =  parcel.readString(),
        Poster =  parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Title)
        parcel.writeString(Year)
        parcel.writeString(Relased)
        parcel.writeString(Runtime)
        parcel.writeString(Genre)
        parcel.writeString(Director)
        parcel.writeString(Actor)
        parcel.writeString(Plot)
        parcel.writeString(Language)
        parcel.writeString(imdbRating)
        parcel.writeString(Poster)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }

}