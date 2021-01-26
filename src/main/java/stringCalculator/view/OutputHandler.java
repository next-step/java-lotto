package stringCalculator.view;

import stringCalculator.Constant;

public class OutputHandler {
    public void printResult(int result) {
        System.out.println(createResult(result));
    }

    private StringBuilder createResult(int result) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(Constant.PRINT_RESULT_FRONT)
            .append(result)
            .append(Constant.PRINT_RESULT_END);
    }
}
