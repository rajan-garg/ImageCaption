package com.microsoft.projectoxford.visionsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.microsoft.projectoxford.vision.VisionServiceRestClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.UnknownHostException;

import static java.lang.System.out;

public class SearchActivity extends ActionBarActivity {

    private EditText sEditText;

    private String url ;

    private String[] array;

    private String title;

    private EditText captionText;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_search);

         Bundle b=this.getIntent().getExtras();
         array = b.getStringArray("taggs");
         url = "https://www.brainyquote.com/search_results.html?q=" + array[1];
        // Log.d("tag0",array[4]);
        captionText = (EditText) findViewById(R.id.captionSearchText);

         try {
             new doCaption().execute(url);
         } catch (Exception e)
         {
             captionText.setText("Error encountered. Exception is: " + e.toString());
         }

       }


    class doCaption extends AsyncTask<String, String, String> {

        //private Exception e=null;

        protected String doInBackground(String... args) {
            try {
                // Connect to the web site
                Document document = Jsoup.connect(url).get();
                // Get the html document title
               // return document.title();

                return document.select("a[title=view quote]").text();
                //Log.d("quote", URLStr);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        protected void onPostExecute(String data) {
            captionText.setText(data);
        }
    }

}