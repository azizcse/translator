package com.w3engineers.translate;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private class ExecuteTranslator extends AsyncTask<String, Void, String> {
        private String text, translatedText;

        int position;

        public ExecuteTranslator() {
            text = "Many";
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                // HashMap<String, String> lastId = YoPreferenceManager.getLastId();
                String clientTranslationID = "_jhgfuywrt--jhfgr";
                String clientTranslationSecretKey = "DTmlfegCk108cENU6f4khvjeLKqmaFL5JvXQqSAWT2I=";
                Translate.setClientId(clientTranslationID);
                Translate.setClientSecret(clientTranslationSecretKey);

                String language = "HINDI";

                if (language.equalsIgnoreCase("ENGLISH")) {
                    translatedText = Translate.execute(text, Language.ENGLISH);
                } else if (language.equalsIgnoreCase("SPANISH")) {
                    translatedText = Translate.execute(text, Language.SPANISH);
                } else if (language.equalsIgnoreCase("FRENCH")) {
                    translatedText = Translate.execute(text, Language.FRENCH);
                } else if (language.equalsIgnoreCase("PORTUGUESE")) {
                    translatedText = Translate.execute(text, Language.PORTUGUESE);
                } else if (language.equalsIgnoreCase("CHINESE")) {
                    translatedText = Translate.execute(text, Language.CHINESE_SIMPLIFIED);
                } else if (language.equalsIgnoreCase("BENGALI")) {
                    translatedText = Translate.execute(text, Language.ENGLISH);
                } else if (language.equalsIgnoreCase("HINDI")) {
                    translatedText = Translate.execute(text, Language.HINDI);
                } else {
                    translatedText = Translate.execute(text, Language.ENGLISH);
                }

                if (translatedText.contains("ArgumentOutOfRangeException")) {
                    translatedText = text;
                }

            } catch (UnknownHostException he) {
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            return translatedText;
        }

        @Override
        protected void onPostExecute(String msg) {

            
        }
    }

}
