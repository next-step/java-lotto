package lotto.view;

import lotto.domain.*;

import java.util.Iterator;
import java.util.List;

public class ResultView {
    private final static String INST_RESULT = "당첨 통계";

    public static void printGeneratedLottos(LottoMachine lottoMachine) {
        Lottos lottos = lottoMachine.getLottos();
        List<Lotto> lottoList = lottos.getLottoList();
        List<Integer> lottoNums;

        for (Lotto lotto : lottoList) {
            lottoNums = lotto.getLottoNums();
            printLottoNums(lottoNums);
        }

        System.out.println();
    }

    private static void printLottoNums(List<Integer> lottoNums) {
        Iterator<Integer> it = lottoNums.iterator();

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

        System.out.println(
                Prize.PRIZE_4TH.matchingCount() + "개 일치 (" +
                Prize.PRIZE_4TH.money() + "원)- " +
                prizeList.get(Prize.PRIZE_4TH.index()) + "개");
        System.out.println(
                Prize.PRIZE_3RD.matchingCount() + "개 일치 (" +
                Prize.PRIZE_3RD.money() + "원)- " +
                prizeList.get(Prize.PRIZE_3RD.index()) + "개");
        System.out.println(
                Prize.PRIZE_2ND.matchingCount() + "개 일치 (" +
                Prize.PRIZE_2ND.money() + "원)- " +
                prizeList.get(Prize.PRIZE_2ND.index()) + "개");
        System.out.println(
                Prize.PRIZE_1ST.matchingCount() + "개 일치 (" +
                Prize.PRIZE_1ST.money() + "원)- " +
                prizeList.get(Prize.PRIZE_1ST.index()) + "개");
    }

    public static void printLottoYield(LottoMachine lottoMachine, List<Integer> winningNums) {
        System.out.println("총 수익률은 " + String.format("%.2f", lottoMachine.getYield(winningNums)) + "입니다.");
    }

    public static void printBuyableLottoNum(LottoMachine lottoMachine) {
        int buyableLottoNum = lottoMachine.buyableLottos();
        System.out.println(buyableLottoNum + "개를 구매했습니다.");
    }
}
