package my.project.lotto.view;


import my.project.lotto.domain.LottoNumber;
import my.project.lotto.domain.Money;
import my.project.lotto.domain.Rank;
import my.project.lotto.dto.Lottos;
import my.project.lotto.dto.ManualCount;
import my.project.lotto.dto.Ranks;

import java.text.DecimalFormat;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class ResultView {
    public static final String MANUAL_PURCHARED = "수동으로 ";
    public static final String AUTO_PURCHARED = "자동으로 ";
    public static final String PURCHASED = "를 구매했습니다.";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String DIVIDE = "---------";
    public static final String FIFTH_PRIZE = "3개 일치 (" + Rank.FIFTH.getPrize() + "원)- ";
    public static final String FOURTH_PRIZE = "4개 일치 (" + Rank.FOURTH.getPrize() + "원)- ";
    public static final String THIRD_PRIZE = "5개 일치 (" + Rank.THIRD.getPrize() + "원)- ";
    public static final String SECOND_PRIZE = "5개 일치, 보너스 볼 일치 (" + Rank.SECOND.getPrize() + "원)- ";
    public static final String FIRST_PRIZE = "6개 일치 (" + Rank.FIRST.getPrize() + "원)- ";
    public static final String UNIT = "개";
    public static final String PROFIT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String COMMA = ", ";

    private ResultView() {
    }

    public static void printLottos(Lottos lottos, ManualCount manualCount) {
        printPurchagedLotto(lottos, manualCount);
        printLotto(lottos);
    }

    private static void printPurchagedLotto(Lottos lottos, ManualCount manualCount) {
        System.out.println(MANUAL_PURCHARED + manualCount.getManualCount() + UNIT
                + COMMA + AUTO_PURCHARED + (lottos.size() - manualCount.getManualCount()) + UNIT + PURCHASED);
    }

    private static void printLotto(Lottos lottos) {
        lottos.getLottos().forEach(lotto -> {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (LottoNumber i : lotto.getLotto()) {
                sb.append(", ").append(i.getNumber());
            }
            sb.append(" ]");
            System.out.println(sb.toString().replaceFirst(",", ""));
        });
    }

    public static void printRanks(Ranks ranks) {
        System.out.println("\n" + WINNING_STATISTICS);
        System.out.println(DIVIDE);
        System.out.println(FIFTH_PRIZE + countFifthRanks(ranks) + UNIT);
        System.out.println(FOURTH_PRIZE + countFourthRanks(ranks) + UNIT);
        System.out.println(THIRD_PRIZE + countThirdRanks(ranks) + UNIT);
        System.out.println(SECOND_PRIZE + countSecondRanks(ranks) + UNIT);
        System.out.println(FIRST_PRIZE + countFirstRanks(ranks) + UNIT);
        System.out.println(String.format(PROFIT, profit(ranks)));
    }

    public static int countFifthRanks(Ranks ranks) {
        return (int) ranks.getRanks().stream()
                .filter(rank -> rank.equals(Rank.FIFTH)).count();
    }

    public static int countFourthRanks(Ranks ranks) {
        return (int) ranks.getRanks().stream()
                .filter(rank -> rank.equals(Rank.FOURTH)).count();
    }

    public static int countThirdRanks(Ranks ranks) {
        return (int) ranks.getRanks().stream()
                .filter(rank -> rank.equals(Rank.THIRD)).count();
    }

    public static int countSecondRanks(Ranks ranks) {
        return (int) ranks.getRanks().stream()
                .filter(rank -> rank.equals(Rank.SECOND)).count();
    }

    public static int countFirstRanks(Ranks ranks) {
        return (int) ranks.getRanks().stream()
                .filter(rank -> rank.equals(Rank.FIRST)).count();
    }

    public static String profit(Ranks ranks) {
        DecimalFormat format = new DecimalFormat("#.##");
        return format.format((double) ((Rank.FIRST.getPrize() * countFirstRanks(ranks))
                + (Rank.SECOND.getPrize() * countSecondRanks(ranks))
                + (Rank.THIRD.getPrize() * countThirdRanks(ranks))
                + (Rank.FOURTH.getPrize() * countFourthRanks(ranks))
                + (Rank.FIFTH.getPrize() * countFifthRanks(ranks)))
                / (ranks.size() * Money.PRICE));
    }

}
