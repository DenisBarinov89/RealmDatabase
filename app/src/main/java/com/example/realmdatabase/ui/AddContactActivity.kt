package com.example.realmdatabase.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.realmdatabase.data.Contact
import com.example.realmdatabase.databinding.ActivityAddContactBinding
import com.example.realmdatabase.presenter.MainAction
import org.koin.android.ext.android.inject

class AddContactActivity : AppCompatActivity(), MainAction {

    private lateinit var binding: ActivityAddContactBinding

    private val presenter: Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.initAction(this)


        binding = ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {

            val id : String? = intent.getStringExtra("id")

            if (id.isNullOrEmpty()) {
                with(binding) {
                    presenter.addContact(
                        name = etName.text.toString(),
                        surname = etSurname.text.toString(),
                        number = etNumber.text.toString()
                    )
                }
            } else {
                with(binding) {
                    presenter.editContact(
                        id = id,
                        name = etName.text.toString(),
                        surname = etSurname.text.toString(),
                        number = etNumber.text.toString()
                    )
                }
            }
            finish()
        }
    }

    override fun onAddContact(contacts: List<Contact>) {
        Toast.makeText(this, contacts.last().name, Toast.LENGTH_SHORT).show()
    }
}