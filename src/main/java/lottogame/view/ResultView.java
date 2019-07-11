package lottogame.view;

import lottogame.domain.*;

import java.text.DecimalFormat;
import java.util.List;

public class ResultView {
    private final static String PATTERN = "#.##";

    public static void printLottoNumber(List<LottoNumber> lottoTotal, int sizeOfManualLotto) {
        System.out.println("수동으로 " + sizeOfManualLotto + "개, 자동으로 " + (lottoTotal.size() - sizeOfManualLotto) + "개를 구매했습니다.");
        for (LottoNumber lottoNumber : lottoTotal) {
            System.out.println(lottoNumber.getElement());
        }
        System.out.println("\n");
    }

    public static void printResult(LottoResult gameResult) {
        List<WinnerGroupDTO> winnerGroup = LottoRankData.makeWinnersGroup();
        DecimalFormat form = new DecimalFormat(PATTERN);

        System.out.println("\n");
        System.out.println("당첨 통계");
        System.out.println("---------");

        winnerGroup.stream()
                .forEach(winner -> {
                    System.out.println(winner.getMatchNum() + "개 일치 (" + winner.getPrize() + "원)- " + winner.getMatchCount() + "개");
                });

        System.out.print("총 수익률은  " + form.format(gameResult.getWinningRevenue().getRevenue()) + "입니다. 기준이 1이기 때문에 결과적으로 " + gameResult.getWinningRevenue().judgeResult() + "라는 의미임)");
    }
}
