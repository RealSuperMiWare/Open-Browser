package com.openbrowser.supermiware.openbrowser;

import android.content.ClipData;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class browserMainActivity extends AppCompatActivity {

    private EditText enterUrl;
    private ImageButton sendUrlButton;
    private WebView siteViewer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser_main);

        createAllVars();

        // Loads the enterUrl EditText bar
        // and sets it to Gone(Invisible)
        sendUrlButton.setVisibility(View.GONE);
        enterUrl.setVisibility(View.GONE);

        sendUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = enterUrl.getText().toString();

                if(!url.contains("https://www.")){

                    String prefixUrl1 = "https://www.";
                    String urlFix1 = prefixUrl1 + url;

                    siteViewer.loadUrl(urlFix1);

                    Log.d("cond: ", "Fail Condition 1");

                }else{
                    Log.d("coudln't Pass ", "Could not pass man.");
                }

                if(!url.contains(".com")){

                    String suffix2 = ".com";
                    String urlFix2 = url + suffix2;

                    siteViewer.loadUrl(urlFix2);
                    Log.d("cond: ", "Fail Condition 2");

                }else{

                    Log.d("coudln't Pass ", "Could not pass man.");
                }

                if(!url.contains("https://www.") & (!url.contains(".com"))){

                    String prefixUrl3 = "https://www.";
                    String suffix3 = ".com";

                    String urlFix3 = prefixUrl3 + url + suffix3;

                    siteViewer.loadUrl(urlFix3);
                    Log.d("cond: ", "This most likely worked 3");

                }else{

                    Log.d("coudln't Pass ", "Could not pass man.");

                }

                sendUrlButton.setVisibility(View.GONE);
                enterUrl.setVisibility(View.GONE);
            }
        });

        siteViewer.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.searchbar, menu);
        return true;

    }

    // When the search glass is selected the enterUrl EditText bar will switch from GONE(Invisible)
    // to VISIBLE
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        createAllVars();

        int id = item.getItemId();
        if(id == R.id.searchUrlBar){
            enterUrl.setVisibility(View.VISIBLE);
            sendUrlButton.setVisibility(View.VISIBLE);
        }

        return true;
    }

    // This method will house all of the intializations in the app
    private void createAllVars(){
        sendUrlButton = findViewById(R.id.sendUrlButton);
        enterUrl = findViewById(R.id.enterUrl);
        siteViewer = findViewById(R.id.siteViewer);
    }
}
