package lotto.view;

import lotto.dto.PurchaseRequest;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_AMOUNT = "구입금액을 입력해 주세요.";

    private static final String INPUT_WINNING_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static PurchaseRequest purchase() {
        System.out.println(INPUT_AMOUNT);
        return new PurchaseRequest(Long.parseLong(scanner.nextLine()));
    }

    public static String winningLotto() {
        System.out.println(INPUT_WINNING_LOTTO);
        return scanner.nextLine();
    }
}
