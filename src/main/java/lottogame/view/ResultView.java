package lottogame.view;

import lottogame.domain.*;
import java.util.List;

public class ResultView {
    public static void printLottoNumber(List<LottoNumber> lottoTotal, int sizeOfManualLotto) {
        System.out.println("수동으로 " + sizeOfManualLotto + "개, 자동으로 " + (lottoTotal.size() - sizeOfManualLotto) + "개를 구매했습니다.");
        for (LottoNumber lottoNumber : lottoTotal) {
            System.out.println(lottoNumber.getElement());
        }
        System.out.println("\n");
    }

    public static void printResult(LottoResult gameResult) {
        List<WinnerGroup> winnerGroup = gameResult.getWinnerGroup();

        System.out.println("\n");
        System.out.println("당첨 통계");
        System.out.println("---------");

        winnerGroup.stream()
                .filter(winner -> !(winner.getRankData().equals(LottoRankData.NO_MATCH)))
                .forEach(winner -> {
                    System.out.println(winner.toString());
                });
        System.out.println(gameResult.getWinningRevenue().toString());
    }
}
