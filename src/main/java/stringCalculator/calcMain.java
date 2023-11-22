package stringCalculator;

import stringCalculator.view.InputView;

public class calcMain {
    public static void main(String[] args) {

        // 입력
        InputView inputView = new InputView();
        String inputString = inputView.inputStringLine("사칙연산을 위한 기호와 숫자를 입력해주세요.(각 문자는 공백으로 구분)");


    }
}
