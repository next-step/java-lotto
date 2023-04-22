package step1;

public class Node {
    private final int value;
    public Node(String current) {
        value = Integer.parseInt(current);
    }
    public int getValue() {
        return value;
    }
}
