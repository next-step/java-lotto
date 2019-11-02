package step1;

public class StringAddCalculator {
    String input;

    public StringAddCalculator(String input) {
        this.input = input;
    }

    int calculate() {
        return 0;
    }

    public boolean isBlank(String input) {
        if(input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }
}
