package lotto.view;

import lotto.domain.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ResultView {
    private final static String INST_RESULT = "당첨 통계";

    public static void printGeneratedLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottoList();
        Set<LottoNumber> lottoNumberSet;

        for (Lotto lotto : lottoList) {
            lottoNumberSet = lotto.getLottoNumberList();
            printLottoNums(lottoNumberSet);
        }

        System.out.println();
    }

    private static void printLottoNums(Set<LottoNumber> lottoNums) {
        Iterator<LottoNumber> it = lottoNums.iterator();

        System.out.print("[" + it.next());
        while (it.hasNext()) {
            System.out.print(", " + it.next());
        }

        System.out.println("]");
    }

    public static void printLottoPrize(WinningResult winningResult) {
        System.out.println(INST_RESULT);
        System.out.println("--------");
        List<Integer> prizeList = winningResult.getWinningResult();

        Prize[] prizes = Prize.values();

        for (int i = prizes.length - 1; i >= 0; i--) {
            printEachPrize(prizeList, prizes[i]);
        }
    }

    static void printEachPrize(List<Integer> prizeList, Prize prize) {
        if (prize.equals(Prize.SECOND)) {
            System.out.println(
                    prize.matchingCount() + "개 일치, 보너스 볼 일치(" +
                            prize.money() + "원)- " +
                            prizeList.get(prize.ordinal()) + "개");
        } else if (!prize.equals(Prize.NONE)) {
            System.out.println(
                    prize.matchingCount() + "개 일치 (" +
                    prize.money() + "원)- " +
                    prizeList.get(prize.ordinal()) + "개");
        }
    }

    public static void printLottoYield(double yield) {
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.");
    }

    public static void printBuyableLottoNum(int buyableLottoNum) {
        System.out.println(buyableLottoNum + "개를 구매했습니다.");
    }
}
