package stringcalculator.ui;

public class ResultView {

    public static void printResult(double value) {
        System.out.println("==================");
        String result = String.format("%.3f", value);
        System.out.println("결과 값 : " + result);
    }
}
