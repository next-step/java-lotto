package step2.view;

import step2.domain.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class OutputView {
    private static final String OUTPUT_BUY_COUNT_MESSAGE = "%s개를 구매했습니다.";
    private static final String OUTPUT_WINNING_STATISTICS_MESSAGE = "당첨 통계\n---------";
    private static final String OUTPUT_RESULT_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String OUTPUT_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치(%d원)- %d개";
    private static final String OUTPUT_YIELD_MESSAGE = "총 수익률은 %.2f 입니다.";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String LOTTO_NUMBER_PREFIX = "[";
    private static final String LOTTO_NUMBER_POSTFIX = "]";

    public void printLottos(Lottos lottos, int count) {
        ViewUtils.printLine(String.format(OUTPUT_BUY_COUNT_MESSAGE, count));

        StringBuilder stringBuilder = new StringBuilder();

        for(Lotto lotto : lottos.getValue()) {
            stringBuilder.setLength(0);

            Set<LottoNumber> lottoNumbers = lotto.getValue();
            stringBuilder.append(getLottoNumbersString(lottoNumbers));

            ViewUtils.printLine(stringBuilder.toString());
        }
    }

    private String getLottoNumbersString(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers
                .stream()
                .sorted()
                .map(LottoNumber::getValue)
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER, LOTTO_NUMBER_PREFIX, LOTTO_NUMBER_POSTFIX));
    }

    public void printResult(LottoResult result, int money) {
        ViewUtils.printLine(OUTPUT_WINNING_STATISTICS_MESSAGE);

        Arrays.stream(LottoTier.values())
                .forEach(tier -> {
                    int tierCount = result.getTierCount(tier);

                    String message = String.format(OUTPUT_RESULT_MESSAGE, tier.getMatchingCount(), tier.getPrize(), tierCount);

                    if(tier.equals(LottoTier.SECOND)) {
                        message = String.format(OUTPUT_SECOND_RESULT_MESSAGE, tier.getMatchingCount(), tier.getPrize(), tierCount);
                    }

                    ViewUtils.printLine(message);
                });

        ViewUtils.printLine(String.format(OUTPUT_YIELD_MESSAGE, result.getYield(money)));
    }
}
