import model.StringAddCalculator;
import view.LottoInput;
import view.LottoOutput;

public class LottoMain {

    public static void main(String[] args) {
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        String inputString = LottoInput.inputGameCoin();

        int result = stringAddCalculator.splitAndSum(inputString);

        LottoOutput.printResult(result);
    }
}
