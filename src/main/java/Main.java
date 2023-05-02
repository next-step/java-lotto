import stringCalculator.domain.Calculation;
import stringCalculator.view.InputView;

public class Main {
    public static void main(String[] args) {

        // 입력 및 계산
        String inputString = InputView.inputOperationsAndNumber();
        InputView.split(inputString);

        //출력
        Calculation calculation = new Calculation();
        System.out.println(calculation.toString());

    }
}
