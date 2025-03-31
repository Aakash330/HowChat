package com.how.chat.domain.usecase

import com.how.chat.domain.repository.UserRepository

class GetUserUseCase(private val repository: UserRepository) {
    operator fun invoke() = repository.getUser()
}