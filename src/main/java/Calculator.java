import java.util.ArrayList;
import java.util.List;

public class Calculator {
    String input;
    private List<String> operator = new ArrayList<>();
    private List<Integer> operand = new ArrayList<>();

    public Calculator(String input) {
        if (isNullOfEmpty(input)) {
            this.input = input;
        }
    }

    public boolean isNullOfEmpty(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력 값이 null 이나 공백은 불가능합니다.");
        }
        return true;
    }

    public void split() {
        String[] strings = input.split(" ");
        for (String string : strings) {
            if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/")) {
                operator.add(string);
            } else {
                operand.add(Integer.valueOf(string));
            }
        }
    }

    public List<String> getOperator() {
        return operator;
    }

    public List<Integer> getOperand() {
        return operand;
    }
}
