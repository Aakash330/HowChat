package com.how.chat.domain.repository

import com.how.chat.data.model.User

interface UserRepository {
    fun getUser(): User
}