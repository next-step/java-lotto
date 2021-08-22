package step1;

import java.util.Objects;

public class NationalNumber {

  private int number;

  public NationalNumber(String number) {
    validate(number);
    this.number = Integer.parseInt(number);
  }

  private void validate(String number) {
    if (isNotNumberOrIsNegativeNumber(number)) {
      throw new IllegalArgumentException("숫자 이외의 값 또는 음수를 입력할 수 없다");
    }
  }

  private boolean isNotNumberOrIsNegativeNumber(String number) {
    return !number.chars().allMatch(Character::isDigit) || Integer.parseInt(number) < 0;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NationalNumber that = (NationalNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }
}
