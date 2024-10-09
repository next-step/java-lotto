package calculation;

public class Calculation {
    public static void main(String[] args) {
        //todo ResultView 분리해서 출력해주어야 할지?
        System.out.println(Calculator.calculateExpression(InputView.input()));
    }
}
