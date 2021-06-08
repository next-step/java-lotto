package lotto;

import java.util.Collections;
import java.util.List;

import static java.lang.String.format;

public class OutputView {
    private static final String MATCH_WORDING = "%s개 일치(%s원)- %s개";
    private static final String MATCH_WORDING_WITH_BONUS = "%s개 일치, 보너스 볼 일치(%s원)- %s개";
    private static final String TOTAL_MATCH_WORDING_LOSS = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String TOTAL_MATCH_WORDING_PROFIT = "총 수익률은 %s 입니다.(기준이 1이기 때문에 결과적으로 이득라는 의미임)";

    private static final String LOTTO_WIN_RESULT_WORDING = "당첨 통계\n---------";
    private static final String LOTTO_BUY_WORDING = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";

    public static void printBuyingCount(BuyingCount manualNum, BuyingCount autoNum) {
        System.out.println(format(LOTTO_BUY_WORDING, manualNum.buyingCount(), autoNum.buyingCount()));
    }

    public static void outputLottoList(LottoTicket lottoTicket) {
        for (int i = 0; i < lottoTicket.getLottoSize(); i++) {
            List<LottoNumber> lottoNum = lottoTicket.getLottoNumWithIdx(i);
            Collections.sort(lottoNum);
            System.out.println(lottoNum);
        }
    }

    public static void printWinResult(LottoTicket lottoTicket) {
        System.out.println(LOTTO_WIN_RESULT_WORDING);
        String output = makeWinWords(lottoTicket);
        System.out.println(output);
    }

    private static String makeWinWords(LottoTicket lottoTicket) {
        String output = getLottoWinTemplate(lottoTicket);
        double totalProfitRatio = LottoStatistics.calculateLottoTicketProfit(lottoTicket);
        if (totalProfitRatio >= 1) {
            output += format(TOTAL_MATCH_WORDING_PROFIT, totalProfitRatio);
            return output;
        }
        output += format(TOTAL_MATCH_WORDING_LOSS, totalProfitRatio);
        return output;
    }

    private static String getLottoWinTemplate(LottoTicket lottoTicket) {
        List<LottoWin> lottoWins = LottoWin.getOutputList();
        String output = "";
        for (LottoWin lottoWin : lottoWins) {
            output += getLottoWinCountString(lottoWin, LottoStatistics.countLottoWinNumMatch(lottoTicket.lottoList(), lottoWin));
        }
        return output;
    }

    private static String getLottoWinCountString(LottoWin lottoWin, int countLottoWinNumMatch) {
        if (lottoWin == LottoWin.SECOND_PLACE) {
            return format(MATCH_WORDING_WITH_BONUS, lottoWin.matchNum(), lottoWin.winPrice(), countLottoWinNumMatch) + "\n";
        }
        return format(MATCH_WORDING, lottoWin.matchNum(), lottoWin.winPrice(), countLottoWinNumMatch) + "\n";
    }

}
