package step2.view;


import step2.domain.Lotto;
import step2.domain.LottoMatchResultCount;
import step2.domain.Lottos;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

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

    public static void printMatchResults(Map<Integer, Long> matchResults) {
        System.out.println("\n당첨 통계\n---------");
        IntStream.range(3, 7)
                .forEach(index -> {
                    int cash = getCash(index);
                    Long amount = matchResults.getOrDefault(index, 0L);

                    System.out.println(
                            index + "개 일치 (" + cash + "원)- " + amount + "개");
                });
    }

    private static int getCash(int index) {
        LottoMatchResultCount lottoMatchResultCount = LottoMatchResultCount.of(index);

        return lottoMatchResultCount.getRewardCash(index);
    }

    public static void printBenefitResult(double benefitPercentage) {
        System.out.println(
                "총 수익률은 " + benefitPercentage + "입니다.(기준이 1이기 때문에 결과적으로 "
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
