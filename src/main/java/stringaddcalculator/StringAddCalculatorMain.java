package stringaddcalculator;

public class StringAddCalculatorMain {

    public static void main(String[] args) {
        // 입력
        String inputValue = View.inputView();

        // 계산
        int result = StringAddCalculator.splitAndSum(inputValue);

        // 출력
        View.outputView(result);
    }
}
