package com.my.muhammadaliftajudin.lab07

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.my.muhammadaliftajudin.lab07.databinding.ActivityConfirmBinding

class ConfirmActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfirmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityConfirmBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.nameTextView.text = intent.getStringExtra("name")
        binding.addressTextView.text = intent.getStringExtra("address")
        binding.cityTextView.text = intent.getStringExtra("city")
        binding.postcodeTextView.text = intent.getStringExtra("postcode")
        binding.stateTextView.text = intent.getStringExtra("state")
        binding.countryTextView.text = intent.getStringExtra("country")

        binding.confirmBtn.setOnClickListener {
            val intent = Intent(this, FinishActivity::class.java)
            startActivity(intent)
        }

        binding.cancelBtn.setOnClickListener {
            finish() // close the current activity page and go to previous page
        }
    }
}