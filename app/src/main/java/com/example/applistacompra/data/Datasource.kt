package com.example.applistacompra.data

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import com.example.applistacompra.R
import com.example.applistacompra.model.Lista
class Datasource() {
    fun loadLista(): List<Lista> {
        return listOf<Lista>(
            Lista(stringResourceId = (R.string.cosa1), integerResourceId = (R.integer.cosa1int)),
            Lista(stringResourceId = (R.string.cosa2),integerResourceId = (R.integer.cosa2int)),
            Lista(stringResourceId = (R.string.cosa3),integerResourceId = (R.integer.cosa3int)),
            Lista(stringResourceId = (R.string.cosa4),integerResourceId = (R.integer.cosa4int)),
            Lista(stringResourceId = (R.string.cosa5),integerResourceId = (R.integer.cosa5int)),
        )
    }
}
