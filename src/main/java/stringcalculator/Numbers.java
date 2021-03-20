package stringcalculator;

public class Numbers {

  private final String[] numbers;

  public Numbers(String[] numbers) {
    this.numbers = numbers;
  }

  public int sum() {
    int sum = 0;
    for (String number : numbers) {
      sum += Integer.parseInt(number);
    }
    return sum;
  }
}
