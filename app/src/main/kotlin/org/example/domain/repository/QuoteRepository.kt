package org.example.domain.repository

import kotlinx.coroutines.flow.Flow
import org.example.domain.model.Quote

interface QuoteRepository {

    // Pide UNA frase aleatoria a la red (una sola vez)
    suspend fun getRandomQuote(): Result<Quote>

    // La lista de favoritos: se actualiza sola cada vez que cambia la base
    fun getFavorites(): Flow<List<Quote>>

    // Guardar y borrar son acciones puntuales
    suspend fun saveFavorite(quote: Quote)
    suspend fun removeFavorite(id: String)

    // ¿Esta frase ya está guardada? (para el botón Guardar / Quitar)
    fun isFavorite(id: String): Flow<Boolean>
}