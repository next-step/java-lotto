package lotto.view;

import lotto.constants.Winning;
import lotto.domain.lotto.Lotto;
import lotto.dto.view.LottoResultDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {
    public static final String PURCHASE_COUNT_MESSAGE = "수동으로 %d장 자동으로 %d개를 구매했습니다.";

    public static final String SUMMARY_HEAD = "당첨 통계";
    public static final String SEPARATOR_LINE = "------------------------";
    private static final String PRIZE_MESSAGE = "%,d개 일치 (%,d원)";
    private static final String MATCH_MESSAGE = " - %,d개";
    private static final String SECOND_MATCH_MESSAGE = ", 보너스 볼 일치 - %,d개";
    public static final String PROFIT_RATE_MESSAGE = "총 수익률은 %,.3f입니다.";


    public void printLottoCount(int manual, int auto) {
        System.out.printf((PURCHASE_COUNT_MESSAGE) + "%n", manual, auto);
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void printSummary(LottoResultDTO lottoResultDTO) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("\n");
        stringBuffer.append(SUMMARY_HEAD).append("\n");
        stringBuffer.append(SEPARATOR_LINE).append("\n");
        appendMessageByWinnings(lottoResultDTO.winnings(), stringBuffer);
        stringBuffer.append(String.format(PROFIT_RATE_MESSAGE, lottoResultDTO.profitRate()));

        System.out.println(stringBuffer);
    }

    private void appendMessageByWinnings(Map<Winning, Long> winnings, StringBuffer stringBuffer) {
        Set<Winning> prizeWinnings = Winning.prizeWinning();

        for (Winning prizeWinning : prizeWinnings) {
            Long matchCount = winnings.get(prizeWinning);
            appendMessageByWinning(prizeWinning, matchCount, stringBuffer);
        }
    }

    private void appendMessageByWinning(Winning prizeWinning, Long matchCount, StringBuffer stringBuffer) {
        stringBuffer.append(String.format(PRIZE_MESSAGE, prizeWinning.matchCount(), prizeWinning.prize()));

        if (prizeWinning == Winning.SECOND) {
            stringBuffer.append(String.format(SECOND_MATCH_MESSAGE, matchCount)).append("\n");
            return;
        }

        stringBuffer.append(String.format(MATCH_MESSAGE, matchCount)).append("\n");
    }
}
