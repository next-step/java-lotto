package step1.algorithm;

public class CalculateUsingDelimiter implements Calculate {

    @Override
    public int execute(String[] operands) {
        int result = 0;

        for (int i = 0; i < operands.length; i++) {
            result += isPositiveNumber(Integer.parseInt(operands[i]));
        }

        return result;
    }

    private int isPositiveNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("피연산자는 반드시 양수값 이어야 합니다.");
        }

        return number;
    }
}
