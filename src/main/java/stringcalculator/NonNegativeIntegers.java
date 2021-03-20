package stringcalculator;

public final class NonNegativeIntegers {

  private final String[] numbers;

  public NonNegativeIntegers(String[] numbers) {
    this.numbers = numbers;
  }

  public NonNegativeInteger sum() {
    NonNegativeInteger total = new NonNegativeInteger();
    for (String number : numbers) {
      total = total.sum(new NonNegativeInteger(number));
    }
    return total;
  }
}
