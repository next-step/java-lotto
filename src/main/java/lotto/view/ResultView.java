package lotto.view;

public class ResultView {

  private static ResultView instance;

  private ResultView() {
  }

  public static ResultView getInstance() {
    if (instance == null) {
      instance = new ResultView();
      return instance;
    }
    return instance;
  }

  public void printResult(String message) {
    System.out.println(message);
  }
}
