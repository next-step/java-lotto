package view;

import domain.Lotto;
import domain.LottoNumber;
import domain.Rank;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleResultView {
    public static void printLottoCount(List<Lotto> lottos){
        System.out.println(lottos.size() + "개를 구매했습니다.");
    }

    public static void printLottosInfo(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            String str = "[" ;
            str += (lotto.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
            str += "]";

            System.out.println(str);
        }
    }

    public static void printTotalResult(Map<Rank, Long> rankGroup, Double profitRate){
        System.out.println("당첨 통계");
        System.out.println("---------");
        printRankGroup(rankGroup);
        printProfitRate(profitRate);
    }

    public static void printRankGroup(Map<Rank, Long> rankGroup){
        for (Rank rank : rankGroup.keySet()) {
            String str = rank.getMatchCount() + "개 일치 ";
            str += "(" + rank.getPrizeMoneyForDisplay() + "원) ";
            str += "- " + rankGroup.get(rank) + "개";
            System.out.println(str);
        }
    }

    public static void printProfitRate(Double profitRate){
        System.out.println("총 수익률은 " + profitRate + "% 입니다.");
    }
}
