package calculator.view;

public class ResultView {

  private static final ResultView INSTANCE = new ResultView();

  private static final String RESULT_FORMAT = "덧셈 결과는 %s";

  private ResultView() {}

  public static ResultView getInstance() {
    return INSTANCE;
  }

  public void printResult(int result) {
    print(result);
  }

  private void print(int result) {
    System.out.printf(RESULT_FORMAT, result);
  }
}
