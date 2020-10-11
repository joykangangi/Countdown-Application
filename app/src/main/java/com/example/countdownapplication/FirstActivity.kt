package com.example.countdownapplication

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.countdownapplication.databinding.ActivityFirstBinding
import java.util.*

class FirstActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener ,
    TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ActivityFirstBinding


    private  var day: Int = 0
    private  var month:Int = 0
    private  var year: Int = 0
    private var hour: Int = 0
    private var minute: Int = 0
    private  var myDay: Int = 0
    private var myMonth: Int = 0
    private var myYear: Int = 0
    private var myHour: Int = 0
    private var myMinute: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView( this, R.layout.activity_first)

        binding.pickButton.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            day =calendar.get(Calendar.DAY_OF_MONTH)
            month = calendar.get(Calendar.MONTH)
            year = calendar.get(Calendar.YEAR)
            val datePickerDialog =
                DatePickerDialog(this@FirstActivity, this@FirstActivity, year, month,day)
            datePickerDialog.show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = day
        myYear = year
        myMonth = month
        val calendar: Calendar = Calendar.getInstance()
        hour = calendar.get(Calendar.HOUR)
        minute = calendar.get(Calendar.MINUTE)
        val timePickerDialog=TimePickerDialog(this@FirstActivity, this@FirstActivity, hour, minute,
            is24HourFormat(this)
        )
        timePickerDialog.show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
            myHour = hourOfDay
            myMinute = minute
                binding.myDate.text =
                    "$myHour:$myMinute\n $myDay/$myMonth/$myYear"

        }
    }
