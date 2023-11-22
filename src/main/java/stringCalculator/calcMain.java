package stringCalculator;

import stringCalculator.domain.StringCalculator;
import stringCalculator.view.InputView;
import stringCalculator.view.ResultView;

public class calcMain {
    public static void main(String[] args) {

        // 입력
        InputView inputView = new InputView();

        // 계산 및 출력
        ResultView.printResult(
                StringCalculator.calculate(inputView.inputStringLine("사칙연산을 위한 기호와 숫자를 입력해주세요.(각 문자는 공백으로 구분)"))
        );

    }
}
