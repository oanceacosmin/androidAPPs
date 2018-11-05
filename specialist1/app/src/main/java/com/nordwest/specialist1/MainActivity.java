package com.nordwest.specialist1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);
        webView.loadUrl("https://partnerships.moodle.roehampton.ac.uk/login/index.php");
        webView.getSettings().setJavaScriptEnabled(true);


    }

    public void onClick(View view) {

        switch(view.getId()){
            case R.id.okButton:
                String text = editText.getText().toString().trim();
                if (text.length() > 0){
                    Toast.makeText(this, getString(R.string.Hello) + text, Toast.LENGTH_LONG).show();
                }
                editText.setText(null);
                break;
            case R.id.cancelButton:
                editText.setText(null);
                break;
            default:
                Toast.makeText(this, getString(R.string.wrong_mess), Toast.LENGTH_LONG).show();
        }

    }
}
