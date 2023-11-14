import java.util.Stack;

public class Postfix {

    private final String postfix;

    public Postfix(String origin) {
        this.postfix = parseToPostfix(origin);
    }

    private String parseToPostfix(String origin) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : origin.toCharArray()) {
            if(Character.isDigit(c)){
                result.append(c);
            }else{
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static Postfix of(String origin) {
        return new Postfix(origin);
    }

    public String postfixString() {
        return this.postfix;
    }
}
