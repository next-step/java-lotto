package stringcalculator;

public class StringArithmeticInput {

    public StringArithmeticInput(String input) {
        if (input == null || input.equalsIgnoreCase("")) {
            throw new IllegalArgumentException("공백은 불가능합니다");
        }

        String[] expressions = input.split(" ");


    }
}
