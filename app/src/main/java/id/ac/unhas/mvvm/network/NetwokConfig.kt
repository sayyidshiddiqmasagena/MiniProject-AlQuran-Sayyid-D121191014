package id.ac.unhas.mvvm.network
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class NetworkConfig {
    private fun getNetwork() : Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.npoint.io/99c279bb173a6e28359c/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun api(): ApiEndPoint{
        return getNetwork().create(ApiEndPoint::class.java)
    }
}
