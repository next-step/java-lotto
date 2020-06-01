package stringaddcalculator;

public class PlusCalculator implements StringArrayCalculator {

  public int calculate(String[] numberArr) {
    int result = 0;

    for (String number : numberArr) {
      try {
        result += Integer.parseInt(number);
      } catch (NumberFormatException e) {
        throw new RuntimeException(e);
      }
    }

    return result;
  }
}
