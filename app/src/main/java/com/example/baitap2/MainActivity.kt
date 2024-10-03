package com.example.baitap2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var buttonSave: Button
    private lateinit var buttonCancel: Button
    private lateinit var editTextName: EditText
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Phần 1 - Thiết lập các nút và sự kiện cho LinearLayout
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        button1.setOnClickListener {
            Toast.makeText(this, "Nút 1 được nhấn", Toast.LENGTH_SHORT).show()
        }

        button2.setOnClickListener {
            Toast.makeText(this, "Nút 2 được nhấn", Toast.LENGTH_SHORT).show()
        }

        button3.setOnClickListener {
            Toast.makeText(this, "Nút 3 được nhấn", Toast.LENGTH_SHORT).show()
        }

        // Phần 2 - Thiết lập ImageView và TextView
        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)

        // Phần 3 - Thiết lập EditText và các nút Save và Cancel trong ConstraintLayout
        editTextName = findViewById(R.id.editTextName)
        buttonSave = findViewById(R.id.buttonSave)
        buttonCancel = findViewById(R.id.buttonCancel)

        // Cập nhật TextView trực tiếp với tên người dùng nhập vào
        editTextName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Không cần xử lý trước khi thay đổi
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Cập nhật TextView chỉ với tên người dùng nhập vào
                textView.text = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {
                // Không cần xử lý sau khi thay đổi
            }
        })

        // Xử lý nút Lưu
        buttonSave.setOnClickListener {
            val name = editTextName.text.toString()
            if (name.isNotEmpty()) {
                Toast.makeText(this, "Đã lưu tên: $name", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Vui lòng nhập tên", Toast.LENGTH_SHORT).show()
            }
        }

        // Xử lý nút Hủy
        buttonCancel.setOnClickListener {
            // Xóa EditText và thông báo hủy
            editTextName.text.clear()
            textView.text = ""
            Toast.makeText(this, "Đã hủy", Toast.LENGTH_SHORT).show()
        }
    }
}
