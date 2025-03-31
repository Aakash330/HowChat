package com.how.chat.di

import com.how.chat.data.repositoryImpl.UserRepositoryImpl
import com.how.chat.domain.repository.UserRepository
import com.how.chat.domain.usecase.GetUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository = UserRepositoryImpl()
    @Provides
    fun provideGetUserUseCase(repository: UserRepository) = GetUserUseCase(repository)
    

}