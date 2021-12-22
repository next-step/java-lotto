package lotto.view;

import lotto.lotto.lottonumber.LottoNumber;
import lotto.lotto.lottonumber.LottoNumbers;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String WINNING_NUMBER_REQUEST_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";

    private InputView() {
    }

    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static LottoNumbers getWinningNumbers() {
        return LottoNumbers.from(scanner.nextLine());
    }

    public static LottoNumber getBonusBall() {
        return new LottoNumber(Integer.parseInt(scanner.nextLine()));
    }

    public static void printWinningNumbersRequest() {
        System.out.println(WINNING_NUMBER_REQUEST_MESSAGE);
    }
}
