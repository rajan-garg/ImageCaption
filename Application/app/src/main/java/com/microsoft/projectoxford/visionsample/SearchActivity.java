package com.microsoft.projectoxford.visionsample;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import java.io.IOException;
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

     public static void main(String[] args) {

         try {
             Document doc = Jsoup.connect("http://www.brainyquote.com").get();
             System.out.println(doc.html());
         }catch (IOException e) {
             e.printStackTrace();
         }
       }

}
