package lotto.view;

import lotto.domain.LottoReport;
import lotto.domain.Pick;
import lotto.domain.Prize;
import lotto.domain.enums.Rank;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public class ResultView {

    private static final String BUY_COUNT_INFO = "%s개를 구매했습니다.\n";
    private static final String PICK_BALLS_INFO = "[%s]\n";
    private static final String REPORT_SUBJECT = "\n당첨 통계\n---------";
    private static final String RANK_RESULT = "%s (%s)- %s개\n";
    private static final String EARNING_RATE_INFO = "총 수익률은 %s 입니다. (기준이 1이기 때문에 결과적으로 %s(이)라는 의미임)";

    public static void myPick(Set<Pick> myPicks) {
        int buyCount = myPicks.size();
        System.out.printf(BUY_COUNT_INFO, buyCount);
        myPicks.forEach(pick -> {
            System.out.printf(PICK_BALLS_INFO, pick.getBalls());
        });
        System.out.println();
    }

    public static void report(Map<Rank, Prize> prizeMap, LottoReport report) {
        System.out.println(REPORT_SUBJECT);
        Map<Rank, Integer> rankMap = report.getRankMap();
        prizeMap.keySet().stream()
                .sorted(Comparator.comparingInt(Enum::ordinal))
                .forEach((rank) -> printPrizeInfo(prizeMap, rankMap, rank));
        System.out.printf(EARNING_RATE_INFO, report.getEarningRate(), report.getEarningRateType().getDescription());
    }

    private static void printPrizeInfo(Map<Rank, Prize> prizeMap, Map<Rank, Integer> rankMap, Rank rank) {
        Prize prize = prizeMap.get(rank);
        Integer rankCount = rankMap.get(rank);
        System.out.printf(RANK_RESULT, prize.getRuleDescription(), prize.getCash(), rankCount == null ? 0 : rankCount);
    }
}
