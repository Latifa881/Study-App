package com.example.studyapp

import androidx.room.*

//Data Access Object
@Dao
interface MaterialsDao {

    @Query("SELECT * FROM KotlinMaterials ")
    fun getKotlinMaterials(): List<KotlinMaterials>
    @Query("SELECT * FROM AndroidMaterials ")
    fun getAndroidMaterials(): List<AndroidMaterials>

    @Insert
    fun insertKotlinReview(kotlinMaterial: KotlinMaterials)
    @Insert
    fun insertAndroidReview(androidMaterial: AndroidMaterials)

    @Update
    fun updateKotlinReview(kotlinMaterial:KotlinMaterials)
    @Update
    fun updateAndroidReview(androidMaterial:AndroidMaterials)
    @Delete

    fun deleteKotlinReview(kotlinMaterial:KotlinMaterials)
    @Delete
    fun deleteAndroidReview(androidMaterial:AndroidMaterials)


}