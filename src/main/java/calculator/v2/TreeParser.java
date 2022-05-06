package calculator.v2;

import java.util.List;

public class TreeParser {

  private static final int FIRST_TOKEN_INDEX = 0;

  private TreeParser() {
  }

  public static Node parsing(List<Token> tokens) {
    validateTokenIsNullOrEmpty(tokens);
    int tokenSize = tokens.size();
    // 첫 번째 토큰이 root
    Node root = new Node(tokens.get(FIRST_TOKEN_INDEX));
    for (int i = 1; i < tokenSize; i++) {
      Token token = tokens.get(i);
      root = add(root, token);
    }
    return root;
  }


  private static Node add(Node root, Token current) {
    Node currentNode = new Node(current);
    Token rootToken = root.token;
    // root 토큰의 우선순위가 현재 토큰의 우선 순위보다 크거나 같은 경우
    if (rootToken.compareTo(current) >= 0) {
      currentNode.left = root;
      // 현재 노드를 루트로 변경
      return currentNode;
    }

    // root 토큰 우선 순위가 현재 토큰의 우선 순위보다 작은 경우
    // 연산자일 때
    if (isOperator(current)) {
      currentNode.left = root.right;
      root.right = currentNode;
      return root;
    }

    // 피연산일 때
    if (isOperand(current)) {
      findRightPositionAndSetCurrentNode(root, currentNode);
      return root;
    }

    return root;
  }

  // root 부터 순회하며 right가 없는 노드를 찾아서 그곳에 현재 피연산자를 추가.
  private static void findRightPositionAndSetCurrentNode(Node root, Node currentNode) {
    Node temp = root;
    while (temp.right != null) {
      temp = temp.right;
    }
    temp.right = currentNode;
  }

  private static void validateTokenIsNullOrEmpty(List<Token> tokens) {
    if (tokens == null || tokens.isEmpty()) {
      throw new IllegalArgumentException("토큰 목록은 빈 값일 수 없습니다.");
    }
  }

  private static boolean isOperand(Token token) {
    return token instanceof Operand;
  }

  private static boolean isOperator(Token token) {
    return token instanceof Operator;
  }
}
