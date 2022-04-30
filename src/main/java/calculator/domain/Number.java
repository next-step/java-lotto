package calculator.domain;

import calculator.exception.InvalidNumberStrException;
import java.util.regex.Pattern;

public class Number {

  private long number;
  private static final Pattern NUMBER_PATTERM = Pattern.compile("^\\d+$");

  public Number(String numberStr) {
    this.number = validateNumber(numberStr);
  }

  public Number(long number) {
    this.number = number;
  }

  public long getNumber() {
    return number;
  }

  private long validateNumber(String numberStr) {
    if (!NUMBER_PATTERM.matcher(numberStr).find()) {
      throw new InvalidNumberStrException("잘못된 숫자 문자열입니다. 입력 : " + numberStr);
    }
    return Long.parseLong(numberStr);
  }
}
