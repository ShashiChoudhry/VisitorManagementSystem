package com.example.visitormanagementsystem

import android.app.DatePickerDialog
import android.content.Context
import android.content.SharedPreferences
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var entryDate : TextView
    private lateinit var exitDate : TextView

    private lateinit var fname : TextView
    private lateinit var lname : TextView
    private lateinit var email: TextView
    private lateinit var phoneNo : TextView

    private lateinit var wheel2 : CheckBox
    private lateinit var wheel3 : CheckBox
    private lateinit var wheel4 : CheckBox

    private lateinit var submit : Button
    private lateinit var clear : Button

    lateinit var sharedPreferences: SharedPreferences
    private val myPreference = "mypref"
    private val EntryDate = "entryDateKey"
    private val ExitDate = "exitDateKey"
    private val FirstName = "fNameKey"
    private val LastName = "lNameKey"
    private val Email = "emailKey"
    private val PhoneNo = "phoneKey"
//    private val Wheel2 = "wheel2Key"
//    private val Wheel3 = "wheel3Key"
//    private val Wheel4 = "wheel4Key"

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

        submit = findViewById(R.id.submitBtn)
        clear = findViewById(R.id.clearBtn)

        fillEntryDate(entryDate as EditText)
        fillEntryDate(exitDate as EditText)
        clearFields()

        sharedPref()

        submit.setOnClickListener() {
            save()
//            showToast()
        }

    }

    fun showToast() {
        val vg:ViewGroup? = findViewById(R.id.custom_toast)
        val inflater = layoutInflater
        val relativeLayout: View = inflater.inflate(R.layout.activity_main,vg) as RelativeLayout
        val tv = relativeLayout.findViewById<TextView>(R.id.txtVw)
        tv.text = "Custom Toast Notification"
        val toast = Toast(applicationContext)
        toast.setGravity(Gravity.CENTER_VERTICAL, 0 , 100)
        toast.duration = Toast.LENGTH_LONG
        toast.view = relativeLayout
        toast.show()
    }


    private fun sharedPref() {
        sharedPreferences = getSharedPreferences(myPreference, Context.MODE_PRIVATE)
        entryDate.text = sharedPreferences.getString(EntryDate, "")
        exitDate.text = sharedPreferences.getString(ExitDate, "")
        fname.text = sharedPreferences.getString(FirstName, "")
        lname.text = sharedPreferences.getString(LastName, "")
        email.text = sharedPreferences.getString(Email, "")
        phoneNo.text = sharedPreferences.getString(PhoneNo, "")

//        wheel2.isChecked = sharedPreferences.getBoolean(Wheel2, false)
//        wheel3.isChecked = sharedPreferences.getBoolean(Wheel3, false)
//        wheel4.isChecked = sharedPreferences.getBoolean(Wheel4, false)

    }

    fun save() {
        val enterDt = entryDate.text.toString()
        val exitDt = exitDate.text.toString()
        val fName = fname.text.toString()
        val lName = lname.text.toString()
        val eml = email.text.toString()
        val phone = phoneNo.text.toString()
//        val whl2 = wheel2.


        val editor = sharedPreferences.edit()
        editor.putString(EntryDate, enterDt)
        editor.putString(ExitDate, exitDt)
        editor.putString(FirstName, fName)
        editor.putString(LastName, lName)
        editor.putString(Email, eml)
        editor.putString(PhoneNo, phone)

        editor.apply()
//        showToast()
    }

    fun get(view: View?) {

        sharedPreferences = getSharedPreferences(myPreference, Context.MODE_PRIVATE)
        entryDate.text = sharedPreferences.getString(EntryDate, "")
        exitDate.text = sharedPreferences.getString(ExitDate, "")
        fname.text = sharedPreferences.getString(FirstName, "")
        lname.text = sharedPreferences.getString(LastName, "")
        email.text = sharedPreferences.getString(Email, "")
        phoneNo.text = sharedPreferences.getString(PhoneNo, "")


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