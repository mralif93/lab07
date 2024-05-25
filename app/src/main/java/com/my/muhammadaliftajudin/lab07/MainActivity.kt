package com.my.muhammadaliftajudin.lab07

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.my.muhammadaliftajudin.lab07.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Variables
        var name = binding.nameEditText;
        var address = binding.addressEditText;
        var city = binding.cityEditText;
        var postcode = binding.postcodeEditText;
        var state = binding.stateEditText;
        var country = binding.countryEditText;
        var scheduleBtn = binding.scheduleBtn;

        // Function
        scheduleBtn.setOnClickListener {
            val intent = Intent(this, ConfirmActivity::class.java)
            intent.putExtra("name", binding.nameEditText.text.toString())
            intent.putExtra("address", binding.addressEditText.text.toString())
            intent.putExtra("city", binding.cityEditText.text.toString())
            intent.putExtra("postcode", binding.postcodeEditText.text.toString())
            intent.putExtra("state", binding.stateEditText.text.toString())
            intent.putExtra("country", binding.countryEditText.text.toString())
            startActivity(intent)
        }
    }
}