package com.example.sideeffects

sealed class ResultType {
    object Sucess : ResultType()
    object Loading : ResultType()
    object Idle : ResultType()


}