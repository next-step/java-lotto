package calculator.v2;

public class Node {

  private final Token token;
  private Node left;
  private Node right;

  public Node(Token token) {
    this.token = token;
  }

  public Node(Token token, Node left, Node right) {
    this.token = token;
    this.left = left;
    this.right = right;
  }
}
