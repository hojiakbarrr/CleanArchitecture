package com.example.cleanarchitecture.core.base


abstract class Mapper<From, To> {
    abstract fun map(from: From): To
}