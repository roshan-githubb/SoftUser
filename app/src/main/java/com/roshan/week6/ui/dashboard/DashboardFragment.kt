package com.roshan.week6.ui.dashboard

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.roshan.week6.MainActivity.Companion.st
import com.roshan.week6.R
import com.roshan.week6.ui.contacts.Contacts


class DashboardFragment : Fragment(), RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private lateinit var fullname: EditText
    private lateinit var age: EditText
    private lateinit var address: EditText
    private lateinit var fname: String
    private lateinit var Address: String
    private lateinit var Gender: String
    private lateinit var Age: String
    private lateinit var btnadd: Button
    private lateinit var rdgroup: RadioGroup
    private var male: RadioButton? = null
    private var female: RadioButton? = null
    private var other: RadioButton? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        fullname = view.findViewById(R.id.fullname)
        age = view.findViewById(R.id.age)
        address = view.findViewById(R.id.address)
        btnadd = view.findViewById(R.id.btnadd)
        rdgroup = view.findViewById(R.id.rdgroup)
        male = view.findViewById(R.id.male)
        female = view.findViewById(R.id.female)
        other = view.findViewById(R.id.other)
        btnadd.setOnClickListener(this)
        rdgroup.setOnCheckedChangeListener(this)
        return view
    }

    override fun onClick(view: View) {
        if (view.id == R.id.btnadd) {
            fname = fullname.text.toString()
            Age = age.getText().toString()
            Address = address.getText().toString()
            if (validate()) {
                st.add(Contacts(fname, Address, Gender, Age))
                Toast.makeText(context, "Student Details is Added", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validate(): Boolean {
        if (TextUtils.isEmpty(fname)) {
            fullname.error = "Please enter a name"
            fullname.requestFocus()
            return false
        }
        if (TextUtils.isEmpty(Age)) {
            age.error = "Please enter age"
            age.requestFocus()
            return false
        }
        if (!TextUtils.isDigitsOnly(Age)) {
            age.error = "Please enter age"
            age.requestFocus()
            return false
        }
        if (TextUtils.isEmpty(Address)) {
            address.error = "Please enter an address"
            address.requestFocus()
            return false
        }
        if (TextUtils.isEmpty(Gender)) {
            Toast.makeText(context, "Please select a gender", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    override fun onCheckedChanged(group: RadioGroup, i: Int) {
        if (i == R.id.male) {
            Gender = "Male"
            //Toast.makeText(this, "Male", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.female) {
            Gender = "Female"
            //Toast.makeText(this, "Female", Toast.LENGTH_SHORT).show();
        }
        if (i == R.id.other) {
            Gender = "Other"
            //Toast.makeText(this, "Other", Toast.LENGTH_SHORT).show();
        }
    }
}