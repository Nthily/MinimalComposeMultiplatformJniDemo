package com.github.nthily.library

internal object Library {

    external fun getStrFromRust(input: String): String

    init {
        System.loadLibrary("jniLib")
    }
}
