package org.example.domain.repository

import org.example.domain.model.User

interface AuthRepository {

    fun isLoggedIn(): Boolean
    fun signOut()

    suspend fun signIn(email: String, password: String): Result<User>
    suspend fun register(email: String, password: String): Result<User>
    suspend fun signInWithGoogle(idToken: String): Result<User>
    suspend fun sendPasswordReset(email: String): Result<Unit>
}