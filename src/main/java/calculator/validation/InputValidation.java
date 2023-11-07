package calculator.validation;

import java.util.List;

public class InputValidation {

    public boolean validation(List<String> input) {
        for(int step = 0; step < input.size(); step++) {
            checkSetValidation(input.get(step), step);
        }
        return true;
    }

    public void nullOrEmptyCheck(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private boolean checkSetValidation(String input, int step) {
        if(step % 2 == 0) {
            checkNumberValidate(input);
        }
        if(step % 2 == 1) {
            checkOperatorValidate(input);
        }
        return true;
    }

    private void checkNumberValidate(String input) {
        if (input.matches(".*[^0-9].*")) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private void checkOperatorValidate(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("연산자는 한글자만 입력해주세요.");
        }
        if(input.matches(".*[^+\\-*/].*")) {
            throw new IllegalArgumentException("연산자가 아닌 값이 입력되었습니다.");
        }
    }
}
