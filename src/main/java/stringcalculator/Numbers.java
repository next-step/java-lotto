package stringcalculator;

public final class Numbers {

  private final String[] numbers;

  public Numbers(String[] numbers) {
    this.numbers = numbers;
  }

  public Number sum() {
    Number total = new Number();
    for (String number : numbers) {
      total = total.sum(new Number(number));
    }
    return total;
  }
}
