package step1.algorithm;

public class CalculateUsingDelimiter implements CalculateAlgorithm{

    @Override
    public int execute(String[] operands) {
        int result = 0;

        for (int i = 0; i < operands.length; i++) {
            if (Integer.parseInt(operands[i]) < 0) {
                throw new RuntimeException("피연산자는 반드시 양수값 이어야 합니다.");
            }

            result += Integer.parseInt(operands[i]);
        }

        return result;
    }
}
