package lotto.view;

import lotto.utils.ScannerUtils;

public final class InputView {

    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static int acceptPuchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        return ScannerUtils.nextInt();
    }

    public static String[] acceptWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return ScannerUtils.nextLine().split(DELIMITER);
    }
}
