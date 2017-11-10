package com.diffblue.javademo.addressbook;

public class SmsServiceMock implements SmsService {

  public String sendMessage(String number, String message) {
    if (number.equals("123") && message.equals("foo")) {
      return "DELIVERED";
    } else if (message.length() > 140) {
      return "MESSAGE_TOO_LONG";
    } else {
      return "UNKNOWN_NUMBER";
    }
  }
}
