package com.example.realmdatabase.data


import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.delete
import io.realm.kotlin.deleteFromRealm
import io.realm.kotlin.where
import java.util.*


class ContactRepositoryImpl(
    private val realm: Realm
) : ContactRepository {
    override fun addContact(name: String, surname: String, number: String) {
        realm.executeTransaction {
            it.createObject(Contact::class.java, UUID.randomUUID().toString()).apply {
                this.name = name
                this.surname = surname
                this.number = number
            }
        }
    }

    override fun getContact(): List<Contact> {
        return realm.where(Contact::class.java).findAll()
    }

    override fun deleteContact(id: String) {
        realm.beginTransaction()
        val result: RealmResults<Contact>  = realm.where(Contact::class.java).equalTo("id", id).findAll()
        result.deleteFirstFromRealm()
        realm.commitTransaction()
    }

    override fun editContact(id: String, name: String, surname: String, number: String) {


        realm.beginTransaction()
        val contact = realm.where(Contact::class.java).equalTo("id", id).findFirst()
        contact?.name = name
        contact?.surname = surname
        contact?.number = number
        if (contact != null) {
            realm.insertOrUpdate(contact)
        }
        realm.commitTransaction()
    }

}