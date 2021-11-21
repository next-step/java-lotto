package lotto.view;

import lotto.util.ScannerUtils;

public class LottoTicketCountView {

    private static final String MESSAGE = "구입금액을 입력해 주세요.";

    private LottoTicketCountView() {
    }

    public static int getLottoTicketCount() {
        System.out.println(MESSAGE);
        return ScannerUtils.nextInt();
    }

}
