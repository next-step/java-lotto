package lottery.view;

import java.text.MessageFormat;
import lottery.dto.LottoResults;
import lottery.domain.LottoTickets;
import lottery.dto.LottoTries;

public class ResultView {

    private static final String PURCHASE_INFO_FORMAT = "\n수동으로 {0}, 자동으로 {1}장을 구매했습니다.";

    public static void printLottoTickets(LottoTickets lottoTickets, LottoTries lottoTries) {
        System.out.println(MessageFormat.format(PURCHASE_INFO_FORMAT, lottoTries.getManualTries(), lottoTries.getRandomTries()));

        System.out.println(lottoTickets.toString() + "\n");
    }

    public static void printLottoResults(LottoResults results) {
        System.out.println(results.toString());
        System.out.printf("총 수익률은 %.2f 입니다.", results.getEarningRate());
    }
}
