package calculator.v2;

public class Node {

  final Token token;
  Node left;
  Node right;

  public Node(Token token) {
    this.token = token;
  }

  public Node(Token token, Node left, Node right) {
    this.token = token;
    this.left = left;
    this.right = right;
  }
}
