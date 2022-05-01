package Lotto.view;

import Lotto.LottoMachine;
import Lotto.MyLottoList;
import Lotto.WinningRankInfo;

import java.util.Map;

public class ResultView {

    private ResultView() {}

    private static int LOTTO_LAST_NUMBER = 6;

    public static void viewLottoNumbers(MyLottoList myLottoList) {
        int lottoNum = myLottoList.getLottoCnt();
        System.out.println(lottoNum + "개를 구매했습니다.");

        for (int i = 0; i < lottoNum; ++i) {
            System.out.print("[");
            viewLottoNumbers(myLottoList, i);
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }

    private static void viewLottoNumbers(MyLottoList myLottoList, int i) {
        for (int k = 0; k < LOTTO_LAST_NUMBER; ++k) {
            System.out.print(myLottoList.getLotto(i).getLottoNumber(k));
            if (k < LOTTO_LAST_NUMBER - 1)
                System.out.print(", ");
        }
    }

    public static void viewResultBoard(Map<Integer, Integer> result) {

        System.out.println("당첨 통계");
        System.out.println("--------");

        for (Integer rank : result.keySet()) {
            if (rank <= 4) {
                String rankMessage = WinningRankInfo.findWinningRank(rank).getRankMessage();
                System.out.println(rankMessage + "- " + result.get(rank) + "개");
            }
        }
    }

    public static void viewLottoYield(Map<Integer, Integer> result, int buyMoney) {
        LottoMachine lottoMachine = new LottoMachine(result);
        String yield = String.format("%.3f",  (lottoMachine.getWinningSumPrice() / (double)(buyMoney)));
        System.out.println("총 수익율은 " + yield + "입니다.");
    }
}
