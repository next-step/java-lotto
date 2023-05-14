package lottoauto.view;

import java.util.stream.Collectors;
import lottoauto.model.Lotto;
import lottoauto.model.LottoResult;
import lottoauto.model.Lottos;

public class OutputView {

    public static final String OPEN_SQUARE_BRACKET = "[";
    public static final String CLOSE_SQUARE_BRACKET = "]";
    public static final String DELEGATOR = ",";

    public static void lottos(Lottos lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(winningNumber(lotto));
        }
    }

    private static String winningNumber(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELEGATOR, OPEN_SQUARE_BRACKET, CLOSE_SQUARE_BRACKET));
    }

    public static void statistics(LottoResult lottoResult, int price) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        lottoResult.getMatchFrequency().forEach((match, count) -> {
            if (match.hasBonus()) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n", match.getMatchCount(), match.getReward(), count);
                return;
            }
            System.out.printf("%d개 일치 (%d원) - %d개\n", match.getMatchCount(), match.getReward(), count);
        });

        System.out.printf("총 수익률은 %f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임.)", lottoResult.getRate(price));

    }
}

