package view;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Lotto;
import domain.LottoBundle;
import domain.LottoNumber;
import domain.LottoStatistics;
import domain.Rank;

import static domain.LottoStatistics.PROFIT_STANDARD;
import static domain.Rank.FIFTH;
import static domain.Rank.FIRST;
import static domain.Rank.FOURTH;
import static domain.Rank.SECOND;
import static domain.Rank.THIRD;

public class ResultView {

    private static void print(Lotto lotto) {
        String formatted = lotto.getLottoNumberList().stream()
            .map(LottoNumber::getNumber)
            .map(String::valueOf)
            .collect(Collectors.joining(", "));

        System.out.println("[" + formatted + "]");
    }

    public static void print(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            print(lotto);
        }
    }

    public static void printBuyCount(int manualCount, int autoBuyCount) {
        System.out.printf("수동으로 %s장, 자동으로 %s개를 구매했습니다.%n", manualCount, autoBuyCount);
    }

    public static void print(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("---------");


        List<Rank> printRank = Arrays.stream(Rank.values())
            .filter(rank -> rank.getWinningMoney() > 0)
            .collect(Collectors.toList());


        for (Rank rank : printRank) {
            System.out.println(RankPrintFormatter.format(rank) + " - " + lottoStatistics.getCountByRank(rank));
        }
    }
}
