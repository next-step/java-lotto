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
                .sorted()
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
        printMatches(rankGroup);
        printProfitRate(profitRate);
    }

    public static void printMatches(Map<Rank, Long> rankGroup){
        rankGroup.keySet().stream()
            .filter(r -> r != Rank.None)
            .map(r -> printMatch(r, rankGroup.get(r)))
            .forEach(System.out::println);
    }

    private static String printMatch(Rank rank, Long value) {
        String str = rank.getMatchCount() + "개 일치";
        if(rank.isMatchBonus()){
            str += ", 보너스 볼 일치";
        }
        str += "(" + rank.getPrizeMoneyForDisplay() + ")";
        str += " - " + value + "개";

        return str;
    }

    public static void printProfitRate(Double profitRate){
        System.out.println("총 수익률은 " + profitRate + "% 입니다.");
    }
}
