package com.example.demoasynctask;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Size {

@SerializedName("sizeTitle")
@Expose
private String sizeTitle;
@SerializedName("sizeFee")
@Expose
private Integer sizeFee;

public String getSizeTitle() {
return sizeTitle;
}

public void setSizeTitle(String sizeTitle) {
this.sizeTitle = sizeTitle;
}

public Integer getSizeFee() {
return sizeFee;
}

public void setSizeFee(Integer sizeFee) {
this.sizeFee = sizeFee;
}

}