package uk.ac.solent.kotlinandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import java.net.URL


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener {
            val artist1 = artist.text.toString()
            doAsync {

                val url = URL("http://www.free-map.org.uk/course/ws/hits.php?artist=$artist1")
                val response = url.readText().replace("<br />", "\n")

                uiThread {
                    output.setText(response)
                }
            }
        }

    }

}
