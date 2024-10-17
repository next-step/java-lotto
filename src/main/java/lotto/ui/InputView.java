package lotto.ui;

import java.util.Scanner;
import lotto.domain.Lotto;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String PURCHASE_PRICE_QUESTION = "구입금액을 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView() {
        throw new UnsupportedOperationException("유틸형 클래스는 생성할 수 없습니다");
    }

    public static int readPurchasePrice() {
        System.out.println(PURCHASE_PRICE_QUESTION);
        int price = SCANNER.nextInt();
        SCANNER.nextLine();
        return price;
    }

    private static void printBlankLine() {
        System.out.println();
    }

    public static String readWinningLottoNumber() {
        printBlankLine();
        System.out.println(WINNING_LOTTO_NUMBER_QUESTION);
        return SCANNER.nextLine();
    }
}
