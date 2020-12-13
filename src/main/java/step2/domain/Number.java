package step2.domain;

public class Number {
  private int number;

  public Number(int number) {
    this.number = number;
  }

  public Number(String number) {
    this.number = Integer.parseInt(number);
  }
}
