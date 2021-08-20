package calculator;

public class NaturalNumber {

  private final int value;

  private NaturalNumber(String input) {
    int num = Integer.parseInt(input);
    checkNonNegative(num);
    value = num;
  }

  public static int parseNaturalNumber(String input) {
    NaturalNumber naturalNumber = new NaturalNumber(input);
    return naturalNumber.value;
  }

  private void checkNonNegative(int num) {
    if (num < 0) {
      throw new RuntimeException("음수 값은 사용될 수 없습니다.");
    }
  }
}
