package stringCalculator.domain;

public class StringCalculator {

  public int calculate(String s) {
    String[] strs = SplitedString.split(s);
    Numbers numbers = new Numbers(strs);
    return numbers.sum();
  }
}
