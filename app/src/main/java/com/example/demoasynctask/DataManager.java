package com.example.demoasynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static DataManager INSTANCE = null;
    private Context context;
    private  List<Item> itemList;
    private LoadJsonTask loadJsonTask = null;
    ILoadDataComplete iLoadDataComplete;

    public static DataManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DataManager(context);
        }
        return(INSTANCE);
    }
    private DataManager(Context context) {
        this.context = context;
    }
    public void startLoadJson() {
        if(loadJsonTask!=null){
            loadJsonTask.cancel(true);
        }
        new LoadJsonTask().execute();
    }

    private class LoadJsonTask extends AsyncTask<Void, Void, List<Item> > {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            itemList = new ArrayList<>();
            iLoadDataComplete = (ILoadDataComplete) context;
        }

        @Override
        protected List<Item> doInBackground(Void... voids) {
            return getJson();
        }

        @Override
        protected void onPostExecute(List<Item> itemList) {
            super.onPostExecute(itemList);

            iLoadDataComplete.onComplete(itemList);

        }
    }
    public String readJson() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("drinks_data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private List<Item> getJson() {
        try {
            JSONArray jsonArray = new JSONArray(readJson());
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Item item = new Item();
                item.setId(jsonObject.getString("id"));
                item.setTitle(jsonObject.getString("title"));
                JSONArray jsonArray1 = jsonObject.getJSONArray("data");
                List<Drink> drinkList = new ArrayList<>();
                for(int j=0;j<jsonArray1.length();j++){
                    JSONObject jsonObject1 = jsonArray1.getJSONObject(j);
                    Drink drink = new Drink();
                    drink.setId(jsonObject1.getString("id"));
                    drink.setName(jsonObject1.getString("name"));
                    drink.setImageURL(jsonObject1.getString("imageURL"));
                    drink.setPrice(jsonObject1.getInt("price"));
                    drink.setType(jsonObject1.getString("type"));
                    drink.setDescription(jsonObject1.getString("description"));
                    try {
                        JSONArray jsonArray2 = jsonObject1.getJSONArray("size");
                        List<Size> sizeList  = new ArrayList<>();
                        for(int h = 0 ; h < jsonArray2.length();h++){
                            JSONObject jsonObject2 = jsonArray2.getJSONObject(h);
                            Size size = new Size();
                            size.setSizeTitle(jsonObject2.getString("sizeTitle"));
                            size.setSizeFee(jsonObject2.getInt("sizeFee"));
                            sizeList.add(size);
                        }
                        drink.setSize(sizeList);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        JSONArray jsonArray2 = jsonObject1.getJSONArray("toping");
                        List<Toping> topingList  = new ArrayList<>();
                        for(int h = 0 ; h < jsonArray2.length();h++){
                            JSONObject jsonObject2 = jsonArray2.getJSONObject(h);
                            Toping toping = new Toping();
                            toping.setToppingName(jsonObject2.getString("toppingName"));
                            toping.setToppingFee(jsonObject2.getInt("toppingFee"));
                            topingList.add(toping);
                        }
                        drink.setToping(topingList);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    drinkList.add(drink);
                }


                item.setData(drinkList);
                itemList.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();

        }
        return itemList;
    }
}
