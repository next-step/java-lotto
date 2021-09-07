package lotto.view;

import lotto.domain.*;

import java.util.*;

public class ResultView {
    private final static String INST_RESULT = "당첨 통계";
    private final static String FORMAT_BOUGHT_LOTTO = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";
    private final static String FORMAT_YIELD = "총 수익률은 %.2f입니다\n";

    public static void printGeneratedLottos(Lottos lottos, AffordableLottoCount affordableLottoCount) {
        List<Lotto> lottoList = lottos.getLottoList();
        Set<LottoNumber> lottoNumberSet;

        for (Lotto lotto : lottoList) {
            lottoNumberSet = lotto.getLottoNumberList();
            printLottoNums(lottoNumberSet);
        }

        System.out.println();
    }

    private static void printLottoNums(Set<LottoNumber> lottoNums) {
        List<LottoNumber> lottoNumberList = new ArrayList<>(lottoNums);
        Collections.sort(lottoNumberList);
        Iterator<LottoNumber> it = lottoNumberList.iterator();

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
        System.out.printf(FORMAT_YIELD, yield);
    }

    public static void printBuyableLottoNum(int manualLottoCount, int AutoLottoCount) {
        System.out.printf(FORMAT_BOUGHT_LOTTO, manualLottoCount, AutoLottoCount);
    }
}
