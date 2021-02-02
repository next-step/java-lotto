package stringCalculator.view;

import stringCalculator.Constant;

public class OutputHandler {
    public void printResult(Integer result) {
        System.out.println(createResult(result));
    }

    private StringBuilder createResult(Integer result) {
        StringBuilder stringBuilder = new StringBuilder();
        if (result == null || result == 0) {
            return stringBuilder.append(Constant.PRINT_ZERO);
        }
        return stringBuilder.append(Constant.PRINT_RESULT_FRONT)
            .append(result)
            .append(Constant.PRINT_RESULT_END);
    }

    public void printErrorNegativeNum() {
        System.out.println(Constant.ERROR_NEGATIVE_NUM);
    }
}
