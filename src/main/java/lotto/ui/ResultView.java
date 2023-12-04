package lotto.ui;

import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.io.PrintStream;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Set;

public class ResultView {
    static final String WINNER_STATISTICS = "당첨 통계";
    static final String RESULT_WINNER = "%d개 일치 (%d원)- %d개\n";

    static final String RESULT_SECOND = "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    static final String TOTAL_AMOUNT = "총 수익률은 %.2f입니다.";
    static final String LOTTO_BUY_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    static final int LOTTO_PRICE = 1000;

    public void PrintThePurchasedLotto(Lottos mergeLottos, int manualCount, int autoCount) {

        System.out.printf(LOTTO_BUY_COUNT, manualCount, autoCount);

        for (int i = 0; i < mergeLottos.getLottosSize(); i++) {
            Iterator<LottoNumber> iterSet = mergeLottos.getLottoIndex(i).getLotto().iterator();
            viewLottoNumbers(iterSet);
            System.out.println();
        }
    }

    private static void viewLottoNumbers(Iterator<LottoNumber> iterSet) {
        while (iterSet.hasNext()) {
            System.out.print(iterSet.next().getNumber() + " ");
        }
    }

    public void PrintTheWinningResults(EnumMap<Rank, Integer> resultMap, int lottoCount) {

        System.out.println(WINNER_STATISTICS);

        resultMap.remove(Rank.MISS);
        int sumAmount = 0;
        Set<Rank> keys = resultMap.keySet();
        for (Rank key : keys) {
            Integer value = Math.toIntExact(resultMap.get(key));
            resultPrintView(key, value);
            sumAmount += value * key.getAmount();
        }

        System.out.printf(TOTAL_AMOUNT, (double) sumAmount / (lottoCount * LOTTO_PRICE));
    }

    private static PrintStream resultPrintView(Rank key, Integer value) {
        if (key == Rank.SECOND) {
            return System.out.printf(RESULT_SECOND, key.getRank(), key.getAmount(), value);
        }
        return System.out.printf(RESULT_WINNER, key.getRank(), key.getAmount(), value);
    }
}
