package step02.code.domain;

import java.util.Objects;

public class Number {
  private static final int MIN_NUM = 1;
  private static final int MAX_NUM = 45;

  private final int number;

  public Number(int number) {
    rangeCheck(number);
    this.number = number;
  }

  public static Number numberByString(String str) {
    int number;
    try {
      number = Integer.parseInt(str);
    } catch(Exception e) {
      throw new IllegalArgumentException("not int error");
    }
    return new Number(number);
  }

  private void rangeCheck(int number) {
    if(number < MIN_NUM || number > MAX_NUM) {
      throw new IllegalArgumentException("lotto 는 " + MIN_NUM + " 부터 " + MAX_NUM + " 사이의 값이어야 합니다");
    }
  }

  public int number() {
    return number;
  }


  @Override
  public boolean equals(Object o) {
    if (o == this)
        return true;
    if (!(o instanceof Number)) {
        return false;
    }
    Number number = (Number) o;
    return this.number == number.number;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(number);
  }

}
