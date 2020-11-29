package my.project.lotto.view;


import my.project.lotto.domain.LottoNumber;
import my.project.lotto.domain.Lottos;
import my.project.lotto.domain.Rank;
import my.project.lotto.domain.Ranks;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class ResultView {
    public static final String PURCHASED = "개를 구매했습니다.";
    public static final String WINNING_STATISTICS = "당첨 통계";
    public static final String DIVIDE = "---------";
    public static final String FIFTH_PRIZE = "3개 일치 (" + Rank.FIFTH.getPrize() + "원)- ";
    public static final String FOURTH_PRIZE = "4개 일치 (" + Rank.FOURTH.getPrize() + "원)- ";
    public static final String THIRD_PRIZE = "5개 일치 (" + Rank.THIRD.getPrize() + "원)- ";
    public static final String SECOND_PRIZE = "5개 일치, 보너스 볼 일치 (" + Rank.SECOND.getPrize() + "원)- ";
    public static final String FIRST_PRIZE = "6개 일치 (" + Rank.FIRST.getPrize() + "원)- ";
    public static final String UNIT = "개";
    public static final String PROFIT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.size() + PURCHASED);
        lottos.getLottos()
                .forEach(lotto -> {
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
        System.out.println(FIFTH_PRIZE + ranks.getFifthRanks() + UNIT);
        System.out.println(FOURTH_PRIZE + ranks.getFourthRanks() + UNIT);
        System.out.println(THIRD_PRIZE + ranks.getThirdRanks() + UNIT);
        System.out.println(SECOND_PRIZE + ranks.getSecondRanks() + UNIT);
        System.out.println(FIRST_PRIZE + ranks.getFirstRanks() + UNIT);
        System.out.println(String.format(PROFIT, ranks.getProfit()));
    }

    private ResultView() {
    }
}
