package stringCalculator.domain;

public class StringCalculator {

  public int calculate(String inputString) {
    String[] stringSeparated = StringSplitter.split(inputString);
    Numbers numbers = new Numbers(stringSeparated);
    return numbers.sum();
  }
}
