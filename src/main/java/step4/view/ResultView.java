package step4.view;


import step4.domain.Lotto;
import step4.domain.Lottos;
import step4.domain.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ResultView {

    public static final int LOTTO_BENEFIT_STANDARD = 1;
    public static final String LOTTO_BENEFIT_TRUE = "이득";
    public static final String LOTTO_BENEFIT_FALSE = "손해";

    public static void printLottos(Lottos lottos) {
        System.out.println("\n" + lottos.getLottos().size() + "개를 구매했습니다.");
        printLottoNumbers(lottos.getLottos());
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        lottos.stream()
                .map(Lotto::getLottoNumbers)
                .forEach(System.out::println);
    }

    public static void printMatchResults(Map<Rank, Long> matchResults) {
        System.out.println("\n당첨 통계\n---------");

        Arrays.stream(Rank.values())
                .sorted(Comparator.comparing(Rank::getWinningMoney))
                .filter(rank -> !rank.equals(Rank.MISS))
                .map(rank -> {
                    Long amount = matchResults.getOrDefault(rank, 0L);
                    return printCountOfMatch(rank, amount);})
                .forEach(System.out::println);
    }

    private static String printCountOfMatch(Rank rank, Long amount) {
        String message = rank != Rank.SECOND ? "개 일치 (" : "개 일치, 보너스 볼 일치 (";
        return rank.getCountOfMatch()
                + message
                + rank.getWinningMoney()
                + "원)- "
                + amount
                + "개";
    }

    public static void printBenefitResult(double benefitPercentage) {
        System.out.println(
                "총 수익률은 "
                        + benefitPercentage
                        + "입니다.(기준이 1이기 때문에 결과적으로 "
                        + getGainOrLoss(benefitPercentage)
                        + "라는 의미임)");
    }

    private static String getGainOrLoss(double benefit) {
        if (benefit < LOTTO_BENEFIT_STANDARD) {
            return LOTTO_BENEFIT_FALSE;
        }
        return LOTTO_BENEFIT_TRUE;
    }

}
