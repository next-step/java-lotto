package step2.view;


import step2.domain.Lotto;
import step2.domain.LottoMatchResult;
import step2.domain.Lottos;

import java.util.List;

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
                .map(Lotto::getLottoNumber)
                .forEach(System.out::println);
    }

    public static void printMatchResults(LottoMatchResult matchResults) {
        matchResults.resultMessages()
                .forEach(System.out::println);

        printBenefitResult(matchResults.resultBenefit());
    }

    private static void printBenefitResult(double benefitPercentage) {

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
