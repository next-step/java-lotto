package calculator.domain;

import calculator.exception.InvalidNumberStrException;

public class Number {

  private long number;

  public Number(String numberStr) {
    this.number = parseNumber(numberStr);
  }

  public Number(long number) {
    this.number = number;
  }

  public long getNumber() {
    return number;
  }

  public Number plus(Number target) {
    number += target.number;
    return this;
  }

  public Number minus(Number target) {
    number -= target.number;
    return this;
  }

  public Number multiply(Number target) {
    number *= target.number;
    return this;
  }

  public Number divide(Number target) {
    number /= target.number;
    return this;
  }

  private long parseNumber(String numberStr) {
    try {
      return Long.parseLong(numberStr);
    } catch (NumberFormatException e) {
      throw new InvalidNumberStrException("잘못된 숫자 문자열입니다. 입력 : " + numberStr);
    }
  }
}
