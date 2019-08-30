package br.com.vinimanara.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import br.com.vinimanara.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Vinicius Manara")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {

        binding.apply {
//            binding.nicknameText.text = binding.nicknameEdit.text

            myName?.nickname = nicknameEdit.text.toString()
            // Invalidate all binding expressions and request a new rebind to refresh UI
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
