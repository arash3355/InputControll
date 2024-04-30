package com.example.inputcontroll

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Date Time Picker
        val dateButton: Button = findViewById(R.id.date_button)
        val dateText: TextView = findViewById(R.id.date_text)

        dateButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePicker = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    dateText.text = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                },
                year,
                month,
                day
            )
            datePicker.show()
        }

        // Phone Number Input
        val phoneEditText: EditText = findViewById(R.id.phone_edit_text)
        val submitButton: Button = findViewById(R.id.submit_button)

        submitButton.setOnClickListener {
            val phoneNumber = phoneEditText.text.toString()
            Toast.makeText(this, "Phone Number: $phoneNumber", Toast.LENGTH_SHORT).show()
        }
    }
}

