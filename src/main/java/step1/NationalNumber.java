package step1;

public class NationalNumber {

  private int number;

  public NationalNumber(String number) {
    validate(number);
  }

  private void validate(String number) {
    if (isNotNumberOrIsNegativeNumber(number)) {
      throw new IllegalArgumentException("숫자 이외의 값 또는 음수를 입력할 수 없다");
    }
  }

  private boolean isNotNumberOrIsNegativeNumber(String number) {
    return !number.chars().allMatch(Character::isDigit) || Integer.parseInt(number) < 0;
  }
}
