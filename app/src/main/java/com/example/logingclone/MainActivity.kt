package com.example.logingclone
import android.os.Bundle
import android.text.InputType
import android.widget.CompoundButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.logingclone.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity(),CompoundButton.OnCheckedChangeListener {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.loginB.setOnClickListener {
            val userName =binding.userName.text.toString()
            Toast.makeText(this@MainActivity, userName, Toast.LENGTH_SHORT).show()
        }
        binding.switchB.setOnCheckedChangeListener(this)
    }
    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

        if (isChecked == true){
            binding.password.inputType =InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            Toast.makeText(this@MainActivity, "Password Visible", Toast.LENGTH_SHORT).show()
        }
        else{
            binding.password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            Toast.makeText(this@MainActivity, "Switch is off", Toast.LENGTH_SHORT).show()
        }
        binding.password.setSelection(binding.password.text.length)

    }
}