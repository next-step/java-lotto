package lotto.view;

import java.util.Scanner;

public class InputView {
    private String formulaString;

    public InputView() {
        System.out.println("계산식을 입력하세요(숫자와 연산자는 공백 기준으로 구분) : ");
        Scanner scanner = new Scanner(System.in);
        String formulaString = scanner.nextLine();
        this.formulaString = formulaString;
    }

    public String getFormulaString() {
        return formulaString;
    }
}
