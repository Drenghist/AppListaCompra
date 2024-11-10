package com.example.applistacompra.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import com.example.applistacompra.R
import com.example.applistacompra.model.Lista
class Datasource() {
    @Composable
    fun loadLista(): List<Lista> {
        return listOf<Lista>(
            Lista(stringResource(R.string.cosa1), integerResourceId = integerResource(R.integer.cosa1int)),
            Lista(stringResource(R.string.cosa2),integerResourceId = integerResource(R.integer.cosa2int)),
            Lista(stringResource(R.string.cosa3),integerResourceId = integerResource(R.integer.cosa3int)),
            Lista(stringResource(R.string.cosa4),integerResourceId = integerResource(R.integer.cosa4int)),
            Lista(stringResource(R.string.cosa5),integerResourceId = integerResource(R.integer.cosa5int)),
        )
    }
}
