package com.example.csdiaryapp.data.repository

import com.example.csdiaryapp.model.Diary
import com.example.csdiaryapp.model.RequestState
import kotlinx.coroutines.flow.Flow
import org.mongodb.kbson.ObjectId
import java.time.LocalDate
import java.time.ZonedDateTime
typealias Diaries = RequestState<Map<LocalDate, List<Diary>>>

interface MongoRepository {
    fun configureTheRealm()
    fun getAllDiaries(): Flow<Diaries>
    fun getFilteredDiaries(zonedDateTime: ZonedDateTime): Flow<Diaries>
    fun getSelectedDiary(diaryId: ObjectId): Flow<RequestState<Diary>>
    suspend fun insertDiary(diary: Diary): RequestState<Diary>
    suspend fun updateDiary(diary: Diary): RequestState<Diary>
    suspend fun deleteDiary(id: ObjectId): RequestState<Boolean>
    suspend fun deleteAllDiaries(): RequestState<Boolean>
}