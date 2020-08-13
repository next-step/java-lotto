package kr.heesu.calculator.domain;

import kr.heesu.calculator.utils.TextUtils;
import kr.heesu.calculator.view.InputView;

import java.util.List;

public class InputParser {
    private String input;

    private InputParser(String userInput) {
        this.input = userInput;
    }

    public static InputParser of(String userInput) {
        return new InputParser(userInput);
    }

    public boolean isInvalidInput() {
        //using text utils
        return false;
    }

    public Expression getExpression() {
        if (isInvalidInput()) {
            throw new IllegalArgumentException("잘못된 입력을 하셨습니다.");
        }

        List<Integer> nums = TextUtils.getNumbers();

        return Expression.of(Arguments.of(nums));
    }
}
