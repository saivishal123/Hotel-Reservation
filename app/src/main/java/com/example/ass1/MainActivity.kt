package com.example.ass1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerRestaurant: Spinner
    private lateinit var editTextDate: EditText
    private lateinit var editTextTime: EditText
    private lateinit var editTextGuests: EditText
    private lateinit var buttonReserve: Button
    private lateinit var textViewReservations: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        spinnerRestaurant = findViewById(R.id.spinnerRestaurant)
        editTextDate = findViewById(R.id.editTextDate)
        editTextTime = findViewById(R.id.editTextTime)
        editTextGuests = findViewById(R.id.editTextGuests)
        buttonReserve = findViewById(R.id.buttonReserve)
        textViewReservations = findViewById(R.id.textViewReservations)

        // Sample list of restaurants
        val restaurants = arrayOf("Hotel Valhalla", "Taj Hotel", "Ichiraku Ramen")

        // Initialize spinner with restaurant names
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, restaurants)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerRestaurant.adapter = adapter

        // Initialize reservations list
        val reservations = mutableListOf<String>()

        // Button click listener for reservation
        buttonReserve.setOnClickListener {
            val restaurant = spinnerRestaurant.selectedItem.toString()
            val date = editTextDate.text.toString()
            val time = editTextTime.text.toString()
            val guests = editTextGuests.text.toString()

            // Validate input fields
            if (restaurant.isNotEmpty() && date.isNotEmpty() && time.isNotEmpty() && guests.isNotEmpty()) {
                // Add reservation to the list
                val reservationDetails = "Reservation for $guests guests at $restaurant on $date at $time"
                reservations.add(reservationDetails)
                textViewReservations.text = reservations.joinToString("\n")

                // Clear input fields
                clearInputs()

                showToast("Reservation added")
            } else {
                showToast("Please fill in all fields.")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun clearInputs() {
        editTextDate.text.clear()
        editTextTime.text.clear()
        editTextGuests.text.clear()
    }
}
