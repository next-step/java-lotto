package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.ticket.LottoTicket;
import lotto.domain.purchase.Purchase;
import lotto.domain.statistics.Statistics;

import java.util.List;
import java.util.Map;

public class ResultView {
    private final static List<String> STATISTICS__WINNER_LIST_SENTENCE = List.of("3개 일치 (5000원) - ", "4개 일치 (50000원) - ", "5개 일치 (1500000) - ", "6개 일치 (2000000000)");
    private final static String ALL_RATIO_SENTENCE = "총 수익률은 ";
    private final static String PURCHASE_SENTENCE = "개를 구매했습니다.";
    private final static String WINNER_STATISTICS = "당첨 통계\n---------\n";
    private final Lotto lotto;

    public ResultView(Lotto lotto) {
        this.lotto = lotto;
    }

    public int purchaseResultView(int money) {
        Purchase purchase = new Purchase(money);
        int purchaseLottoCount = purchase.purchase();
        purchaseSentence(purchaseLottoCount);
        lotto.purchaseLotto(purchaseLottoCount);
        getLottoNumbersSentence(lotto);
        return purchaseLottoCount;
    }


    public void getLottoNumbersSentence(Lotto lotto) {
        String lottoStr = lotto.toString().replace(",", "");
        int length = lottoStr.length();
        System.out.println(lottoStr.substring(1, length - 1));
    }

    public void purchaseSentence(int purchaseLottoCount) {
        System.out.println(purchaseLottoCount + PURCHASE_SENTENCE);
    }

    public void statisticsResultView(LottoTicket lastWeekWinningNumbers, int purchaseLottoCount) {
        System.out.println(WINNER_STATISTICS);
        Map<Integer, Integer> hitLottoNumbers = lotto.getHitLottoNumbers(lastWeekWinningNumbers);
        Statistics statistics = new Statistics(hitLottoNumbers);
        prizeResultView(statistics);
        System.out.println(ALL_RATIO_SENTENCE + statistics.calculateReturnRatio(purchaseLottoCount) + "입니다.");
    }

    private static void prizeResultView(Statistics statistics) {
        List<Integer> prizeCounts = statistics.getTotalPrizeAmounts();
        for(int i=0; i<prizeCounts.size(); i++) {
            System.out.println(STATISTICS__WINNER_LIST_SENTENCE.get(i) + prizeCounts.get(i));
        }
    }

}
