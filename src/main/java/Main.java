import domain.Calculator;
import view.InputView;

public class Main {

  public static void main(String[] args) {

    String question = InputView.question();
    Calculator calculator = new Calculator();
    int result = calculator.calculate(question);
    System.out.println("정답은 " + result + " 입니다");
  }

}
