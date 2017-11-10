package com.diffblue.javademo.addressbook;

/**
 * Representation of an individual record within the addressBook.
 * name - the full name of the person
 * phoneNumber - the fully qualified phone number
 */

public class Person {
  private String name;
  private String phoneNumber;

  /**
   * Setter for Name.
   * @param name the new name as a String
   */

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for Name.
   * @return the full name of the person
   */

  public String getName() {
    return this.name;
  }

  /**
   * Setter for phone number.
   * @param number the fully qualified phone number (i.e. with area and country code)
   */

  public void setPhoneNumber(String number) {
    this.phoneNumber = number;
  }

  /**
   * Getter for the phone number.
   * @return String of the phone number
   */

  public String getPhoneNumber() {
    return phoneNumber;
  }

}

  

