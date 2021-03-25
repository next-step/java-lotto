package step2.view;

import java.util.Scanner;

public final class InputView {

    private static InputView instance;
    private final Scanner scanner;

    private InputView() {
        scanner = new Scanner(System.in);
    }

    public static final InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    private final int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    private final String inputWinningLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.\n");
        return scanner.nextLine();
    }

}
