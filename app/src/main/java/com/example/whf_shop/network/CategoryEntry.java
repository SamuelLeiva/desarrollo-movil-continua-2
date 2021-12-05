package com.example.whf_shop.network;

import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.example.whf_shop.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CategoryEntry {
    private static final String TAG = CategoryEntry.class.getSimpleName();

    public final String title;
    public final Uri dynamicUrl;
    public final String url;
    public final String qty;

    public CategoryEntry(String title, String dynamicUrl, String url, String qty) {
        this.title = title;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        this.url = url;
        this.qty = qty;
    }

    public static List<CategoryEntry> initCategoryEntryList(Resources resources){
        InputStream inputStream = resources.openRawResource(R.raw.categories);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try {
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while((pointer = reader.read(buffer)) != -1){
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException exception){
            Log.e(TAG, "Error al escribir o leer el archivo JSON", exception);
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception){
                Log.e(TAG, "Error al cerrar la conexion con el archivo");
            }
        }

        String jsonCategoriesString = writer.toString();
        Gson gson = new Gson();
        Type categoryListType = new TypeToken<ArrayList<CategoryEntry>>() {
        }.getType();

        return gson.fromJson(jsonCategoriesString, categoryListType);

    }
}
