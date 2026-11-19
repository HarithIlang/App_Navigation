package com.example.app_navigation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Team(
    @param:StringRes val stringResourceId: Int,
    @param:DrawableRes val imageResourceId: Int
)