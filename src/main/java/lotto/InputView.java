package lotto;

import jdk.internal.util.xml.impl.Input;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_PRINT = "개를 구매했습니다.";
    private static final String LAST_WEEKS_WINNING_NUMBER ="지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS = "당첨통계";

    private Scanner sc;

    public InputView() {
        sc = new Scanner(System.in);
    }

    public void printInputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE);
    }

    public String inputPurchasePrice() {
        return sc.nextLine();
    }

    public void printPurchasePrice(LottoCount lottoCount) {
        System.out.println(lottoCount.getLottoCount() + PURCHASE_PRINT);
    }

    public void printLastWeeksWinningNumber() {
        System.out.println(LAST_WEEKS_WINNING_NUMBER);
    }

    public String inputLastWeeksWinningNumber() {
        return sc.nextLine();
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS);
    }
}
