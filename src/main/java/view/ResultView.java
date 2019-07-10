package view;

import domain.LottoNumber;
import domain.LottoResult;
import domain.LottoRankData;
import domain.WinnerGroupDTO;

import java.util.List;

public class ResultView {
    public static List<LottoNumber> printLottoNumber(List<LottoNumber> lottoTotal, List<LottoNumber> lottoAuto) {
        System.out.println("수동으로 " + lottoTotal.size() + "개, 자동으로 " + lottoAuto.size() + "개를 구매했습니다.");
        lottoTotal.addAll(lottoAuto);
        for (LottoNumber lottoNumber : lottoTotal) {
            System.out.println(lottoNumber.getElement());
        }
        System.out.println("\n");

        return lottoTotal;
    }

    public static void printResult(LottoResult gameResult) {
        List<WinnerGroupDTO> winnerGroup = LottoRankData.makeWinnersGroup();

        System.out.println("\n");
        System.out.println("당첨 통계");
        System.out.println("---------");

        winnerGroup.stream()
                .forEach(winner -> {
                    System.out.println(winner.getMatchNum() + "개 일치 (" + winner.getPrize() + "원)- " + winner.getMatchCount() + "개");
                });

        System.out.print("총 수익률은  " + gameResult.getPercentOfRevenue() + "입니다. 기준이 1이기 때문에 결과적으로 " + gameResult.judgeResult() + "라는 의미임)");
    }
}
