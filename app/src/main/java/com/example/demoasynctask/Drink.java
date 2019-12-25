package com.example.demoasynctask;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Drink {

@SerializedName("id")
@Expose
private String id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("imageURL")
@Expose
private String imageURL;
@SerializedName("price")
@Expose
private Integer price;
@SerializedName("type")
@Expose
private String type;
@SerializedName("size")
@Expose
private List<Size> size = null;
@SerializedName("description")
@Expose
private String description;
@SerializedName("toping")
@Expose
private List<Toping> toping = null;

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getImageURL() {
return imageURL;
}

public void setImageURL(String imageURL) {
this.imageURL = imageURL;
}

public Integer getPrice() {
return price;
}

public void setPrice(Integer price) {
this.price = price;
}

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public List<Size> getSize() {
return size;
}

public void setSize(List<Size> size) {
this.size = size;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public List<Toping> getToping() {
return toping;
}

public void setToping(List<Toping> toping) {
this.toping = toping;
}

}