package step01.code.domain;

public class Number {
  
  private final int number;

  public Number(int number) {
    this.number = number;
  }

  public Number(String str) {
    this.number = parseInt(str);
  }

  public int number() {
    return number;
  }

  public int parseInt(String str) {
    return Integer.parseInt(str);
  }

}
