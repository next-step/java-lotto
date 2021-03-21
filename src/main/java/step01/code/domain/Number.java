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
    int number = Integer.parseInt(str);
    if(number < 0) {
      throw new IllegalArgumentException("숫자는 음수일수 없습니다.");
    }
    return number;
  }

}
