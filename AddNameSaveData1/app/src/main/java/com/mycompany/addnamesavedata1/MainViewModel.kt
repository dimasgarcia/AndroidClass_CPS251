package com.mycompany.addnamesavedata1

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val names = mutableListOf<String>()

    fun addName(name: String) {
        names.add(name)
    }

    fun getNames(): List<String> = names
}
