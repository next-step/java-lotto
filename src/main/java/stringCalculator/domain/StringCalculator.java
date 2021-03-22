package stringCalculator.domain;

public class StringCalculator {

  public int calculate(String s) {
    String[] strs = StringSplitter.split(s);
    Numbers numbers = new Numbers(strs);
    return numbers.sum();
  }
}
