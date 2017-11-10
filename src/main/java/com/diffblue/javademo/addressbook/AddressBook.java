package com.diffblue.javademo.addressbook;

import com.google.inject.Inject;

import java.util.ArrayList;

/** The address Book.
 * addressBook - list of people
 */

public class AddressBook {

  private ArrayList<Person> addressBook = new ArrayList<Person>();
  private SmsService textService;

  public void addPerson(Person person) {
    addressBook.add(person);
  }

  /** Get the phone number for person with the name.
   * @param name String fullname of the person
   * @return String full phone number (inc. country and area code)
   */

  public String getNumber(String name) {
    for (Person person : addressBook) {
      if (person.getName().equals(name)) {
        return person.getPhoneNumber();
      }
    }
    return "";
  }

  /** Send a text message to a person.
   * @param name full name of the person
   * @param message that will be sent
   * @return SUCCESS or error message
   */

  public String sendMessage(String name, String message) {
    String number = getNumber(name);
    if (number.isEmpty()) {
      return "NO_NUMBER";
    }
    if (message.isEmpty()) {
      return "NO_MESSAGE";
    }
    if (textService.sendMessage(number, message).equals("DELIVERED")) {
      return "DELIVERED";
    } else {
      return "FAILED";
    }
  }

  @Inject
  public void setTextService(SmsService textService) {
    this.textService = textService;
  }

}