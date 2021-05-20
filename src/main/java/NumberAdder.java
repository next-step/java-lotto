public class NumberAdder {

  public int add(String[] numbers) {
    int sum = 0;
    for (String number : numbers) {
      sum += getParsedNumberOf(number);
    }

    return sum;
  }

  private int getParsedNumberOf(String number) {
    int parsedNumber = Integer.parseInt(number);
    if (parsedNumber < 0) {
      throw new RuntimeException();
    }

    return parsedNumber;
  }
}
