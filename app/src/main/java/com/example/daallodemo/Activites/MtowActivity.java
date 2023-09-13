package com.example.daallodemo.Activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.daallodemo.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MtowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtow);

        String url = "https://daallo.com/api/flight/calendar?From=DXB&To=MGQ";

        ArrayList<String> nameArrayList = new ArrayList<>();

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    String day = jsonObject.getString("day");
                    nameArrayList.add(day);

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MtowActivity.this, android.R.layout.simple_expandable_list_item_1,nameArrayList);


                }catch (Exception e){
                    e.printStackTrace();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MtowActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}