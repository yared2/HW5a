package com.example.hw5a

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.hw5a.R
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    var reslt: Int = 0
    var question2result: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
        fun submit(view: View) {
            reslt = 0;

            var ans1 = findViewById(R.id.yes) as RadioButton

            if (ans1.isChecked) {
                reslt += 50
            }

            var ans2a = findViewById(R.id.bytt) as CheckBox
            var ans2b = findViewById(R.id.shortt) as CheckBox
            var ans2c = findViewById(R.id.floatt) as CheckBox
            if (!ans2c.isChecked) {
                if (ans2b.isChecked) {
                    reslt += 25
                }
                if (ans2a.isChecked) {
                    reslt += 25
                }
            }

            var time = Calendar.getInstance().time
            val alertdial = AlertDialog.Builder(this)
            alertdial.setTitle("Resul ")
            alertdial.setMessage(
                "Congratulations! You submitted on \n " +
                        "  $time , \n You achieved  $reslt% "
            )
            alertdial.setPositiveButton("yes") { DialogInterface, which: Int ->
                Toast.makeText(this, "you slected yes", Toast.LENGTH_LONG)
                DialogInterface.dismiss()
                finish()
            }
            alertdial.setNegativeButton("cancel")
            { DialogInterface, which: Int ->
                Toast.makeText(this, "you selected cancel", Toast.LENGTH_LONG)
                DialogInterface.dismiss()
                finish()
            }
            alertdial.setNeutralButton("undecided") { DialogInterface, which: Int ->
                Toast.makeText(this, "Not decided", Toast.LENGTH_LONG)
                DialogInterface.dismiss()
                finish()
            }
            alertdial.show()
        }
        fun onReset(view: View) {
            yes.isChecked = false
            no.isChecked = false
            shortt.isChecked = false
            bytt.isChecked = false
            floatt.isChecked = false
            reslt = 0

        }

    }

