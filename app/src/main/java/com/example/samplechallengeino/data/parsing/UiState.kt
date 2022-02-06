package com.example.samplechallengeino.data.parsing

sealed class UiState

object LoadingState: UiState()
object ContentState: UiState()
object ErrorState: UiState()