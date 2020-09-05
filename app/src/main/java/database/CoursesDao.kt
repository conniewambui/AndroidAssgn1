package database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.Coursess

@Dao
interface CoursesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCourse(coursess: Coursess)

    @Query(value = "SELECT * FROM coursess")
    fun getAllCourses(): List<Coursess>
}