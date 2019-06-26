package step1;

public class CalculatorApplication {
    private InputView inputView;

    private CalculatorApplication() {
        this.inputView = new InputView();
    }

    public static void main(String[] args) {
        CalculatorApplication app = new CalculatorApplication();
        StringAddCalculator stringAddCalculator = new StringAddCalculator();
        SplitDomain splitDomain = new SplitDomain();

        String inputNumber = app.inputView.inputNumbers();
        int possibleCalculateNumber = stringAddCalculator.checkInputNumber(inputNumber);

        if (possibleCalculateNumber == 0) {
            System.out.println(possibleCalculateNumber);
        }
        if (possibleCalculateNumber != 0) {
            int[] numberToAdd = splitDomain.checkSplitInputNumber(inputNumber);
            stringAddCalculator.add(numberToAdd);
        }


    }
}
