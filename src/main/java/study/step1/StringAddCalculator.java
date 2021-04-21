package study.step1;

public class StringAddCalculator {

  public StringAddCalculator() {
  }

  public int splitAndSum(String text) {
    if (Validator.isEmpty(text)) {
      return 0;
    }

    TokenDelimiter tokenDelimiter = new TokenDelimiter(text);

    TokenNumbers tokenNumbers = new TokenNumbers(tokenDelimiter.getNumberTokens());

    Numbers numbers = new Numbers(tokenNumbers.convertNumbers());

    numbers.validatorNumbers();

    return numbers.sum();
  }

}
