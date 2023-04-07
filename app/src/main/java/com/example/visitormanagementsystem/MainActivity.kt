package com.example.visitormanagementsystem

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var entryDate : EditText
    private lateinit var exitDate : EditText
    private lateinit var fname : EditText
    private lateinit var lname : EditText
    private lateinit var email: EditText
    private lateinit var phoneNo : EditText

    private lateinit var wheel2 : CheckBox
    private lateinit var wheel3 : CheckBox
    private lateinit var wheel4 : CheckBox

    private lateinit var submit : Button
    private lateinit var clear : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        entryDate = findViewById(R.id.enterDateField)
        exitDate = findViewById(R.id.ExitField)
        fname = findViewById(R.id.fNameField)
        lname = findViewById(R.id.lNameField)
        email = findViewById(R.id.emailField)
        phoneNo = findViewById(R.id.phoneNoField)

        wheel2 = findViewById(R.id.twoWheelerBox)
        wheel3 = findViewById(R.id.threeWheelerBox)
        wheel4 = findViewById(R.id.fourWheelerBox)

        clear = findViewById(R.id.clearBtn)

        fillEntryDate(entryDate)
        fillEntryDate(exitDate)
        clearFields()

    }

    private fun fillEntryDate(time : EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog1 = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                // Update the text of the EditText with the selected date
                val selectedDate = "$year-${month+1}-$dayOfMonth"
                time.setText(selectedDate)
            },
            year,
            month,
            day
        )

        time.setOnClickListener {
            datePickerDialog1.show()
        }
    }

    private fun clearFields() {

        clear.setOnClickListener {
            fname.setText("")
            lname.setText("")
            email.setText("")
            phoneNo.setText("")
            entryDate.setText("")
            exitDate.setText("")

            wheel2.isChecked = false
            wheel3.isChecked = false
            wheel4.isChecked = false
        }
    }
}