package stringCalculator;

public class Application {
    public static void main(String[] args) {
        Input input = new Input();
        OutPut outPut = new OutPut();

        String sentence = input.askInput();
        outPut.printResult(StringCalculator.calculate(sentence));
    }
}
