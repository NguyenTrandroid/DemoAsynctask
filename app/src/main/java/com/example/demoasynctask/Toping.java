package com.example.demoasynctask;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Toping {

@SerializedName("toppingName")
@Expose
private String toppingName;
@SerializedName("toppingFee")
@Expose
private Integer toppingFee;

public String getToppingName() {
return toppingName;
}

public void setToppingName(String toppingName) {
this.toppingName = toppingName;
}

public Integer getToppingFee() {
return toppingFee;
}

public void setToppingFee(Integer toppingFee) {
this.toppingFee = toppingFee;
}

}