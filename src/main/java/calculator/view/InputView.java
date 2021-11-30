package calculator.view;

import java.util.Scanner;

public class InputView {

  private static final InputView INSTANCE = new InputView();

  private static final String QUESTION_EXPRESSION = "덧셈할 식을 입력해주세요.";
  private static final String EXPLAIN_DEFAULT_DELIMITER = "기본 구분자는 :와 ,입니다.";
  private static final String EXPLAIN_CUSTOM_DELIMITER = "커스텀 구분자는 “//”와 “\\n” 사이에 위치하는 문자를 "
      + "커스텀 구분자로 사용합니다. (ex. //!\\n1!2 -> 구분자 : !, 결과 : 3)";

  private InputView() {}

  public static InputView getInstance() {
    return INSTANCE;
  }

  public String inputExpression() {
    print(QUESTION_EXPRESSION);
    print(EXPLAIN_DEFAULT_DELIMITER);
    print(EXPLAIN_CUSTOM_DELIMITER);
    return new Scanner(System.in).next();
  }

  private void print(String question) {
    System.out.println(question);
  }
}
