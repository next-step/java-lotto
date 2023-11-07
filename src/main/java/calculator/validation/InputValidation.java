package calculator.validation;

import java.util.List;

public class InputValidation {

    public boolean validation(List<String> input) {
        for(int step = 0; step < input.size(); step++) {
            checkSetValidation(input.get(step), step);
        }
        return true;
    }

    private boolean checkSetValidation(String input, int step) {
        if(step % 2 == 0 && !checkNumber(input)) {
            return false;
        }
        if(step % 2 == 1 && !checkOperator(input)) {
            return false;
        }
        return true;
    }

    private boolean checkNumber(String input) {
        if (input.matches(".*[^0-9].*")) {
            return false;
        }
        return true;
    }

    private boolean checkOperator(String input) {
        if(input.matches(".*[^+\\-*/].*")) {
            return false;
        }
        return true;
    }
}
