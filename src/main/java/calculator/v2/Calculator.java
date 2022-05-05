package calculator.v2;

import java.util.List;

public class Calculator {

  private Calculator() {
  }

  public static int calculate(String input) {
    validateInput(input);
    List<Token> tokens = Lexer.lex(input);
    SyntaxAnalyzer.analyze(tokens);
    Node root = TreeParser.parsing(tokens);
    return calculatePostfix(root);
  }

  private static void validateInput(String input) {
    if (input == null || input.isBlank()) {
      throw new IllegalArgumentException("빈 식은 계산할 수 없습니다.");
    }
  }

  private static int calculatePostfix(Node root) {
    // 연산자의 경우 - left right 노드가 모두 존재
    if (root.left != null && root.right != null) {
      int lvalue = calculatePostfix(root.left);
      int rvalue = calculatePostfix(root.right);

      Operator operator = convertToOperator(root);
      return operator.apply(lvalue, rvalue);
    }

    // 피연산자의 경우- 피연산자는 자식 노드가 없음
    Operand op = (Operand) (root.token);
    return op.getValue();
  }

  private static Operator convertToOperator(Node root) {
    return (Operator) (root.token);
  }
}
