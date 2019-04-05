package com.deushdezt.labo4_pdm_00084417.activities.utils

import android.net.Uri
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*

class NetworkUtils{
    val MOVIES_API_URL = "http://www.omdbapi.com/";
    val TOKEN_API = "57eae034";

    fun buildSearchUrl(movieName :String):URL{
        val builtUri = Uri.parse(movieName)
            .buildUpon()
            .appendQueryParameter("apikey",TOKEN_API)
            .appendQueryParameter("t",movieName)
            .build();
        return try {
            URL(builtUri.toString());

        }catch (e:MalformedURLException){
            URL("");
        }
    }
    @Throws (IOException::class)
    fun getResponseFromHttpUrl(url: URL):String{
        var urlConnection = url.openConnection() as HttpURLConnection;
        try {
            val `in` = urlConnection.inputStream
            val scanner = Scanner(`in`);
            scanner.useDelimiter("\\A")
            val hasInput = scanner.hasNext()
            return if(hasInput){
                scanner.next()
            }
            else{
                ""
            }
        }finally {
            urlConnection.disconnect()
        }
    }
}