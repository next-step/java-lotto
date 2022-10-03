package calculator.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String SEPARATOR = " ";

    public List<String> receiveFormula() {
        System.out.println("계산식을 입력해주세요. 숫자와 연산자를 공백으로 구분합니다. ex) 6 + 5 - 4 * 3 / 2");
        String input = new Scanner(System.in).nextLine();
        return List.of(input.split(SEPARATOR));
    }
}
