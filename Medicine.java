import java.util.*;
import java.time.LocalDate;


public class Medicine {
  private String code;
  private String name;
  private double price;
  private int quantity;
  private String date;

  public Medicine(String code, String name, double price, int quantity, String date) {

    this.code = code;
    this.name = name;
    this.price = price;
    this.quantity = quantity;
    this.date = date.split(" ", 2)[0];
  }

  public Medicine(String code, String name, double price, int quantity) {

    this.code = code;
    this.name = name;
    this.price = price;
    this.quantity = quantity;

    this.date = LocalDate.now().toString();
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public String getDate() {
    return date;
  }




  public void setCode(String code) {
    this.code = code;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "code: " + code + ", name: " + name + ", price: " + price + ", date: " + date + ", quantity: " + quantity;
  }

}
