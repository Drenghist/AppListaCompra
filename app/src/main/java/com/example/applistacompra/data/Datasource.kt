package com.example.applistacompra.data

import com.example.applistacompra.R
import com.example.applistacompra.model.Lista

class Datasource() {
    fun loadLista(): List<Lista> {
        return listOf<Lista>(
            Lista(R.string.cosa1, R.integer.cosa1int),
            Lista(R.string.cosa2,R.integer.cosa2int),
            Lista(R.string.cosa3,R.integer.cosa3int),
            Lista(R.string.cosa4,R.integer.cosa4int),
            Lista(R.string.cosa5,R.integer.cosa5int),
        )
    }
}
