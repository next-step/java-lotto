package stringCalculator;

public class Calculator {
  public void run() {
    System.out.println("식을 입력해 주세요(각 원소는 공백을 기준으로 구분됩니다)");
    String input = Reader.read();
    Expression expression = Parser.parse(input);
    Number result = expression.evaluate();
    System.out.println(result.value());
  }
}
