package lotto.view;

import lotto.util.ScannerUtils;

public class WinnerNumberView {

    private static final String MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private WinnerNumberView() {
    }

    public static String getWinnerNumber() {
        System.out.println(MESSAGE);
        return ScannerUtils.nextLine();
    }

}
