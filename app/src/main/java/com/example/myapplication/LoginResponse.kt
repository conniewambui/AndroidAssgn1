
import com.google.gson.annotations.SerializedName
import ke.co.app.Student


data class RegistrationResponse(
    @Student.SerializedName("access_token") var access: String,
    @Student.SerializedName("message") var message: String
)
