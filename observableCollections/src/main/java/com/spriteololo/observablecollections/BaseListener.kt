package com.spriteololo.observablecollections

interface BaseListener {
    val TAG: String

    companion object {
        const val functionNotUsed = "listener was called, but wasn't implemented /"
    }
}