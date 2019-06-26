package step1;

public class CalculatorApplication {
    private InputView inputView;
    private static StringAddCalculator stringAddCalculator;

    private CalculatorApplication(){
        this.inputView = new InputView();
        this.stringAddCalculator = new StringAddCalculator();
    }

    public static void main(String[] args){
        CalculatorApplication app = new CalculatorApplication();
        stringAddCalculator .inputNumberCheck(app.inputView.inputNumbers());

    }
}
