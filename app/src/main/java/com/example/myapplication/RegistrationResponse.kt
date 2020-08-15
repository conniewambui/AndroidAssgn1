
package ke.co.app

import com.google.gson.annotations.SerializedName
import ke.co.app.Student


data class RegistrationResponse(
    @Student.SerializedName("message") var message: String,
    @Student.SerializedName("student") var student: Student
)