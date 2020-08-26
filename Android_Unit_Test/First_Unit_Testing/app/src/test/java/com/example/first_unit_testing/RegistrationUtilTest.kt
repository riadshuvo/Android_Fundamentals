package com.example.first_unit_testing



import com.google.common.truth.Truth.assertThat
import org.junit.Test


class RegistrationUtilTest{

    @Test
    fun `empty username return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "", "123","123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password return true`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Phillip", "123","123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `username already exists return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Pitter", "123","123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Phillip", "",""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password repeated incorrectly return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Phillip", "123","321"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password contains less than 2 digit return false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            "Phillip", "asbs2","asbs2"
        )
        assertThat(result).isFalse()
    }

}