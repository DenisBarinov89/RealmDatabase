package com.example.realmdatabase.presenter

import com.example.realmdatabase.data.Contact

interface MainAction {

    fun onAddContact(contacts: List<Contact>)
}