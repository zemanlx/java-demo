package com.diffblue.javademo.addressbook;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {

  private Injector injector;

  @Before
  public void setUp() throws Exception{
    injector = Guice.createInjector(new AbstractModule() {
      @Override
      protected void configure() {
        bind(SmsService.class).to(SmsServiceMock.class);
      }
    });
  }

  @After
  public void tearDonw() throws Exception {
    injector = null;
  }

  /**
   * Test case for sendMessage success
   */

  @Test
  public void sendMessageSuccess() {
    // Arrange
    AddressBook myAddressBook = injector.getInstance(AddressBook.class);
    Person p = new Person();
    p.setName("foo");
    p.setPhoneNumber("123");
    myAddressBook.addPerson(p);

    // Act
    String returnValue = myAddressBook.sendMessage("foo","foo");

    // Assert
    Assert.assertEquals("DELIVERED", returnValue);
  }

  /**
   * Test case for no number
   */
  @Test
  public void sendMessageNoNumber() {
    // Arrange
    AddressBook myAddressBook = injector.getInstance(AddressBook.class);
    Person p = new Person();
    p.setName("foo");
    p.setPhoneNumber("123");
    myAddressBook.addPerson(p);

    // Act
    String returnValue = myAddressBook.sendMessage("bar","foo");

    // Assert
    Assert.assertEquals("NO_NUMBER", returnValue);
  }

  /**
   * Test case for message too long
   */
  @Test
  public void sendMessageTooLong() {
    // Arrange
    AddressBook myAddressBook = injector.getInstance(AddressBook.class);
    Person p = new Person();
    p.setName("foo");
    p.setPhoneNumber("123");
    myAddressBook.addPerson(p);

    // Act
    String returnValue = myAddressBook.sendMessage("foo","012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567891");

    // Assert
    Assert.assertEquals("FAILED", returnValue);
  }

  /**
   * Test case for no message
   */
  @Test
  public void sendNoMessage() {
    // Arrange
    AddressBook myAddressBook = injector.getInstance(AddressBook.class);
    Person p = new Person();
    p.setName("foo");
    p.setPhoneNumber("123");
    myAddressBook.addPerson(p);

    // Act
    String returnValue = myAddressBook.sendMessage("foo","");

    // Assert
    Assert.assertEquals("NO_MESSAGE", returnValue);
  }
}

