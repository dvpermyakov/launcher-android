package com.dvpermyakov.launcher

import android.content.Intent
import android.graphics.drawable.Drawable

data class ApplicationItem(
    val name: String,
    val packageName: String,
    val icon: Drawable,
    val intent: Intent?
)