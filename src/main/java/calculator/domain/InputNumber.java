package calculator.domain;

import calculator.StringUtils;

public class InputNumber {

    private final int number;

    public InputNumber(String number) {
        if (StringUtils.isEmpty(number.trim())) {
            throw new RuntimeException("input 값이 빈값이면 안됩니다.");
        }
        this.number = Integer.parseInt(number.trim());

    }

    public int getNumber() {
        return number;
    }
}
