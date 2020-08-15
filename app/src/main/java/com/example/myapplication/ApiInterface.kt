package ke.co.app

import android.telecom.Call
import okhttp3.RequestBody
import retrofit2.http.Body


interface ApiInterface {
    @POST("register")
    fun registerStudent(@Body requestBody: RequestBody): retrofit2.Call<RegistrationResponse>
}

