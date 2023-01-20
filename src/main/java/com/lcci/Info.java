
package com.lcci;

public class Info {

  private String  message ;

  public Info() {
    this.message= "Default message";
  }

  public void setMessage(String message) {
    this.message= message;
  }

  public String toString() {
    return "value of message: "+this.message;
  }

}
