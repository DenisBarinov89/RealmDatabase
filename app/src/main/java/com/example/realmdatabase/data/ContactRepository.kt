package com.example.realmdatabase.data

import com.example.realmdatabase.data.Contact

interface ContactRepository {

    fun addContact(name: String, surname: String, number: String)

    fun getContact(): List<Contact>

    fun deleteContact(id: String)

    fun editContact(id: String, name: String, surname: String, number: String)
}