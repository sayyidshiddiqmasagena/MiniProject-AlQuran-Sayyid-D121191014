package id.ac.unhas.mvvm.model

import android.content.Context
import com.google.gson.Gson
import java.io.IOException

class DataSource {
    companion object{
        fun createDataSet(jsonString: String): DataAlquran{

            val gson = Gson()
            val data: DataAlquran = gson.fromJson(jsonString, DataAlquran::class.java)

            return data
        }

        fun getJsonDataFromAsset(context: Context, fileName: String): String? {
            val jsonString: String
            try {
                jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
            } catch (ioException: IOException) {
                ioException.printStackTrace()
                return null
            }
            return jsonString
        }
    }
}