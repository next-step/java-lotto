package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.PurchaseInformation;

import java.util.List;

public class PrintView {

    public static final String BUY_RESULT_MESSAGE = "수동으로 %d개, 자동으로 %d개를 구매했습니다.%n";
    public static final String RESULT_TITLE_MESSAGE = "당첨 통계";
    public static final String DELIMITER_LINE = "---------";

    public void printLottoNumbers(List<LottoNumbers> lottoNumbers, PurchaseInformation purchaseInfo) {
        System.out.println();
        System.out.printf(BUY_RESULT_MESSAGE, purchaseInfo.manualCount(), purchaseInfo.autoCount());

        for (LottoNumbers numbers : lottoNumbers) {
            System.out.println(numbers);
        }
        System.out.println();
    }

    public void printResult(String result) {
        System.out.println();
        System.out.println(RESULT_TITLE_MESSAGE);
        System.out.println(DELIMITER_LINE);
        System.out.println(result);
    }
}
