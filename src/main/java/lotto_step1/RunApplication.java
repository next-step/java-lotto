package lotto_step1;

import java.util.List;

public class RunApplication {
    public static void main(String[] args) {
        String value = InputView.getInputValue();

        List<String> splitValues = StringSplit.splitInputValue(value, StringSplit.checkCustomSeparator(value));
        StringSplit.checkSplitValues(splitValues);

        int result = CalculatorSum.sum(splitValues);
        System.out.println(result);
    }
}
