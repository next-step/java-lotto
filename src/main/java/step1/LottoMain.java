package step1;

import step1.model.StringAddCalculator;
import step1.view.LottoInput;
import step1.view.LottoOutput;

public class LottoMain {

    public static void main(String[] args) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        String inputString = LottoInput.inputGameCoin();

        int result = stringAddCalculator.splitAndSum(inputString);

        LottoOutput.printResult(result);
    }
}
