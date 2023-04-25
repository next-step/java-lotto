package step1;

public class Node {
    private final int value;

    public Node(String current) {
        value = Integer.parseInt(current);
    }

    public static boolean nodeConvertible(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getValue() {
        return value;
    }
}
