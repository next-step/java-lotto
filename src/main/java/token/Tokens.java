package token;

import number.Number;
import operator.Operation;

import java.util.List;
import java.util.Stack;

public class Tokens {
    private final Stack<String> tokens;

    private Tokens(Stack<String> tokens) {
        this.tokens = tokens;
    }

    public static Tokens from(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (int index = list.size() - 1; index >= 0; index--) {
            stack.push(list.get(index));
        }
        return new Tokens(stack);
    }


    public Number number() {
        return Number.from(get());
    }

    public Operation operation() {
        return Operation.from(get());
    }


    private String get() {
        return tokens.pop();
    }

    public void add(int token) {
        tokens.push(String.valueOf(token));
    }

    public boolean empty() {
        return tokens.isEmpty();
    }

    public boolean notEmpty() {
        return !empty();
    }

    public boolean last() {
        return tokens.size() == 1;
    }
}