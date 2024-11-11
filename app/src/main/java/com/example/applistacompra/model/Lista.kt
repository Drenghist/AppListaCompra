package com.example.applistacompra.model

import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Lista(
    @StringRes val stringResourceId: Int,
    @IntegerRes val integerResourceId: Int
)


