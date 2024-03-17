package step1.dto;

public class CalculateRequestDto {

    private String[] values;

    public CalculateRequestDto(String value) {
        validateNull(value);
        this.values = splitValues(value);
        validValues();
    }

    private void validateNull(String value) {
        if (value == null) {
            throw new IllegalArgumentException("입력값은 null이면 안됩니다.");
        }
    }

    private String[] splitValues(String values) {
        return values.split(" ");
    }

    private void validValues() {
        isValuesOdd();
        isValidValues();
    }

    private void isValuesOdd() {
        if (values.length % 2 == 0) {
            throw new IllegalArgumentException("계산이 가능한 수식을 입력해주세요");
        }
    }

    private void isValidValues() {
        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0)
                isNumeric(values[i]);
            if (i % 2 == 1)
                validOperator(values[i]);
        }
    }

    private void isNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 사칙연산 숫자 순으로 입력해주세요");
        }
    }

    private void validOperator(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
            return;
        throw new IllegalArgumentException("정상적인 사칙연산 기호를 입력해주세요.");
    }

    public String[] getValues() {
        return values;
    }
}
