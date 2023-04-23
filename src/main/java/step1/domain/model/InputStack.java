package step1.domain.model;

import java.util.*;

public class InputStack {
    private static final String DELIMITER = " ";

    private Stack<String> input;

    public InputStack(Stack<String> input) {
        this.input = input;
    }

    public static InputStack from(String input) {
        Stack<String> inputStack = new Stack<>();

        for (String string : revers(input.split(DELIMITER))) {
            inputStack.push(string);
        }

        return new InputStack(inputStack);
    }


    private static String[] revers(String[] inputStrings) {
        List<String> list = Arrays.asList(inputStrings);
        Collections.reverse(list);
        return list.toArray(inputStrings);
    }

    public int getSize() {
        return input.size();
    }

    public String pop() {
        return input.pop();
    }

    public void push(String result) {
        input.push(result);
    }

}
