package step1;

public class CalCulatorMain {
    public static void main(String[] args) {
        String input = InPutView.input();
        ResultView.print(Calculator.calculator(input));
    }
}
