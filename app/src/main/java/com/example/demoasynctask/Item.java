package com.example.demoasynctask;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

@SerializedName("id")
@Expose
private String id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("data")
@Expose
private List<Drink> data = null;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public List<Drink> getData() {
return data;
}

public void setData(List<Drink> data) {
this.data = data;
}

}