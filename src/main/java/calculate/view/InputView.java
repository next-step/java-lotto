package calculate.view;

import java.util.Scanner;

public class InputView {
    private String input;

    public InputView() {
    }

    public void getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("계산할 구분자와 문자열을 입력 하세요");

        this.input = sc.nextLine();
    }

    public String getInput() {
        return input;
    }
}
