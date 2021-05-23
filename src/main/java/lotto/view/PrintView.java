package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;

import java.util.List;

public class PrintView {

    public static final String BUY_RESULT_MESSAGE = "수동으로 %d개, 자동으로 %d개를 구매했습니다.%n";
    public static final String RESULT_TITLE_MESSAGE = "당첨 통계";
    public static final String DELIMITER_LINE = "---------";

    public void printLottoNumbers(List<LottoNumbers> manualLottoNumbers, List<LottoNumbers> autoLottoNumbers) {
        System.out.println();
        System.out.printf(BUY_RESULT_MESSAGE, manualLottoNumbers.size(), autoLottoNumbers.size());

        for (LottoNumbers autoLottoNumber : autoLottoNumbers) {
            System.out.println(autoLottoNumber);
        }

        for (LottoNumbers manualLottoNumber : manualLottoNumbers) {
            System.out.println(manualLottoNumber);
        }
        System.out.println();
    }

    public void printResult(LottoResult lottoResult, int price) {
        System.out.println();
        System.out.println(RESULT_TITLE_MESSAGE);
        System.out.println(DELIMITER_LINE);
        System.out.print(lottoResult.resultMessage(price));
    }
}
