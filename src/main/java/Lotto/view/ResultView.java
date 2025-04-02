package Lotto.view;

import Lotto.dto.RankResultDto;

import java.util.List;

public class ResultView {
    public void printBuyNum(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    public void printLotto(List<List<Integer>> numbers) {
        for (List<Integer> lotto : numbers) {
            System.out.println(lotto);
        }
    }

    public void printWinStatistics(List<RankResultDto> results, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        results.forEach(dto -> System.out.printf(
                "%d개 일치 (%d원)- %d개\n",
                dto.getMatchCount(),
                dto.getPrize(),
                dto.getCount()
        ));

        if (profitRate < 1) {
            System.out.println("총 수익률은 " + profitRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        } else {
            System.out.println("총 수익률은 " + profitRate + "입니다.");
        }
    }
}
