package calculator;

public class CalculatorMain {

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator();
        try{
            String text = InputView.getInputText();
            String output = String.valueOf(stringCalculator.add(text));
            OutputView.printOutput(output);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
