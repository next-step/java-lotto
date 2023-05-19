package lottoauto.view;

import java.text.MessageFormat;
import java.util.stream.Collectors;
import lottoauto.model.Lotto;
import lottoauto.model.LottoResult;
import lottoauto.model.Lottos;

public class OutputView {

    public static final String OPEN_SQUARE_BRACKET = "[";
    public static final String CLOSE_SQUARE_BRACKET = "]";
    public static final String DELIMITER = ",";

    public static void lottos(Lottos lottos, int manualCount) {
        String message = MessageFormat.format("수동으로 {0}장, 자동으로 {1}장을 구매했습니다.", manualCount, lottos.getSize() - manualCount);
        System.out.println(message);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(winningNumber(lotto));
        }
    }

    private static String winningNumber(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getNumber()))
                .collect(Collectors.joining(DELIMITER, OPEN_SQUARE_BRACKET, CLOSE_SQUARE_BRACKET));
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

