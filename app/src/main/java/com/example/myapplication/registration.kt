import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.form.ApiClient
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import ke.co.app.ApiInterface
import ke.co.app.RegistrationResponse
import kotlinx.android.synthetic.main.activity_registration.*
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import okhttp3.MultipartBody

class registration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)


        val phoneNumber = editTextPhone.text.toString()
        val password = editTextTextPassword.text.toString()
        val passwordConfirmation = editTextTextPassword3.text.toString()
        val email = emailAddress.text.toString()
        val LastName = editTextTextPersonName3.text.toString()
        val FirstName = firstName1.text.toString()
        
        
        var requestBody = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("first_name", FirstName)
            .addFormDataPart("last_name", LastName)
            .addFormDataPart("email", email)
            .addFormDataPart("phone_number", phoneNumber)
            .addFormDataPart("password", password)
            .build()

        registerUser(requestBody)
        Toast.makeText(baseContext, LastName, Toast.LENGTH_SHORT).show()
    }
}


fun registerUser(requestBody: RequestBody) {
    var apiClient = ApiClient.buildService(ApiInterface::class.java)
    var registrationCall = apiClient.registerStudent(requestBody)
    registrationCall.enqueue(object : Callback<RegistrationResponse> {
        fun onFailure(
            call: Call<RegistrationResponse>,
            t: Throwable,
            baseContext: Context
        ) {
            Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
        }

        fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>, baseContext: Context) {
            if (response.isSuccessful) {
                Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                startActivity(Intent(baseContext, MainActivity::class.java))
            } else {
                Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                    .show()
            }
        }

        private fun startActivity(intent: Intent) {
            TODO("Not yet implemented")
        }

        override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
            TODO("Not yet implemented")
        }

        override fun onResponse(
            call: Call<RegistrationResponse>,
            response: Response<RegistrationResponse>
        ) {
            TODO("Not yet implemented")
        }
    })
}

private fun Any.enqueue(any: Any) {

}