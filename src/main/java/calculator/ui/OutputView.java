package calculator.ui;

public class OutputView {

  private OutputView() {
  }

  public static void printResult(int result) {
    System.out.println("결과: " + result);
  }

  public static void printError(String message) {
    System.out.println("오류: " + message);
  }
}