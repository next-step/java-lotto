package view;

import java.util.Scanner;

public class InputView {

    private static final InputView instance = new InputView();

    private InputView() {}

    public static InputView getInstance() {
        return instance;
    }

    private static final Scanner SCANNER = new Scanner(System.in);

    public String askExpression() {
        return askMessage("계산할 수식을 입력해 주세요. 숫자와 연산자 사이에 공백을 입력해야 합니다.");
    }

    public String askPriceToPay() {
        return askMessage("구입 금액을 입력해 주세요.");
    }

    public String askWinnerLottoNumber() {
        return askMessage("지난 주 당첨 번호를 입력해 주세요.(예 - 1, 3, 5, 7, 9, 11)");
    }

    private String askMessage(String message) {
        System.out.println(message);

        return SCANNER.nextLine();
    }
}
