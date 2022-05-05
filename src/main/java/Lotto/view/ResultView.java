package Lotto.view;

import Lotto.domain.Lottos;
import Lotto.domain.WinningRankInfo;

import java.util.Map;

public class ResultView {

    private ResultView() {}

    private static int LOTTO_LAST_NUMBER = 6;

    public static void viewLottoNumbers(Lottos lottos) {
        int lottoNum = lottos.getLottoCnt();
        System.out.println(lottoNum + "개를 구매했습니다.");

        for (int i = 0; i < lottoNum; ++i) {
            System.out.print("[");
            viewLottoNumbers(lottos, i);
            System.out.print("]");
            System.out.println();
        }
        System.out.println();
    }

    private static void viewLottoNumbers(Lottos lottos, int i) {
        for (int j = 0; j < LOTTO_LAST_NUMBER; ++j) {
            System.out.print(lottos.getLotto(i).getLottoNumber(j));
            if (j < LOTTO_LAST_NUMBER - 1)
                System.out.print(", ");
        }
    }

    public static void viewResultBoard(Map<WinningRankInfo, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("--------");

        for (WinningRankInfo rank : result.keySet()) {
            if (rank.isValidRank()) {
                String rankMessage = rank.getRankMessage();
                System.out.println(rankMessage + "- " + result.get(rank) + "개");
            }
        }
    }

    public static void viewLottoYield(double yield) {
        System.out.println("총 수익율은 " + yield + "입니다.");
    }
}
