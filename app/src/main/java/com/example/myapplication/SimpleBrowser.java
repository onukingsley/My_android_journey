package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SimpleBrowser extends AppCompatActivity {

    EditText editText;
    Button button;
    LinearLayout linearLayout;
    WebView webView;
    ProgressDialog progressDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_browser);

        editText = findViewById(R.id.url);
        button = findViewById(R.id.search);
        linearLayout = findViewById(R.id.lay);
        webView = findViewById(R.id.webview);
        progressDialog = new ProgressDialog(SimpleBrowser.this);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                /*if (url.startsWith("https.youtube"))*/

                progressDialog.show();
                linearLayout.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);


                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressDialog.dismiss();
                if(url.trim().length()>20){
                    editText.setText(url.substring(0,20)+"......");
                }
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                progressDialog.dismiss();
                Toast.makeText(SimpleBrowser.this, String.valueOf(error), Toast.LENGTH_SHORT).show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = editText.getText().toString();
                if (url.trim().length()<3){
                    editText.setError("invalid url");
                }
                if(!url.trim().startsWith("https://")){
                    url = "http://"+url;
                }
                progressDialog.show();
                webView.loadUrl(url);
            }
        });

        /*webView.loadUrl("https://google.com");*/

    }
}