package com.example.intent_passing_dataclass

import android.text.Editable
import java.io.Serializable

class Person(
    val id: Int,
    val name: String,
    val email: String
): Serializable