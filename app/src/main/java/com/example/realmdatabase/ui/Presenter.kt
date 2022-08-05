package com.example.realmdatabase.ui

import com.example.realmdatabase.data.ContactRepository
import com.example.realmdatabase.presenter.MainAction

class Presenter(private val contactRepository: ContactRepository) {

    private var mainAction: MainAction? = null


    fun initAction(mainAction: MainAction) {
        this.mainAction = mainAction
    }

    fun addContact(name: String, surname: String, number: String) {
        contactRepository.addContact(name, surname, number)
        mainAction?.onAddContact(contactRepository.getContact())
    }

    fun editContact(id: String, name: String, surname: String, number: String) {
        contactRepository.editContact(id, name, surname, number)
    }



}