package com.indrajeet.chauhan.materialuitutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: MaterialButton = findViewById(R.id.showBottomSheet)
        button.setOnClickListener {
            val bottomSheetDialog: BottomSheetDialog = BottomSheetDialog(this@MainActivity)
            val view: View =
                LayoutInflater.from(this@MainActivity).inflate(R.layout.bottom_sheet_layout, null)
            bottomSheetDialog.setContentView(view)
            bottomSheetDialog.show()

            val textInputLayout: TextInputLayout = view.findViewById(R.id.textFieldLayout)
            val editText: TextInputEditText = view.findViewById(R.id.edit_text_id)
            val dismissBtn: MaterialButton = view.findViewById(R.id.dismiss)

            dismissBtn.setOnClickListener {
                if (editText.text.isNullOrEmpty()) {
                    textInputLayout.error = "Please type some text"
                } else {
                    Toast.makeText(this@MainActivity, editText.text.toString(), Toast.LENGTH_SHORT)
                        .show()
                    bottomSheetDialog.dismiss()
                }
            }

            bottomSheetDialog.setOnDismissListener {
                Toast.makeText(this@MainActivity, "Bottom Sheet dismissed", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}