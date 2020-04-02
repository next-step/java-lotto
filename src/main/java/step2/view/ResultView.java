package step2.view;

import step2.ViewUtils;
import step2.domain.*;

import java.util.*;
import java.util.stream.Collectors;

public class ResultView {
    private static final String LOTTO_COUNT_INFORMATION = "%s개를 구매했습니다.";
    private static final String WINNING_STATISTICS_INFORMATION = "당첨 통계\n---------";
    private static final String MATCH_RESULT_INFORMATION = "%d개 일치 (%d원)- %d개";
    private static final String YIELD_INFORMATION = "총 수익률은 %.2f 입니다.";
    private static final String LOTTO_NUMBER_PREFIX = "[";
    private static final String LOTTO_NUMBER_POSTFIX = "]";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    public void showLottos(Lottos lottos, int count) {
        ViewUtils.printLine(String.format(LOTTO_COUNT_INFORMATION, count));
        printLottoNumbers(lottos);
    }

    private void printLottoNumbers(Lottos lottos) {
        StringBuilder builder = new StringBuilder();

        for(Lotto lotto : lottos.getValue()) {
            builder.setLength(0);

            Set<LottoNumber> lottoNumbers = lotto.getValue();
            builder.append(getLottoNumbersString(lottoNumbers));
            ViewUtils.printLine(builder.toString());
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

    public void showResult(LottoResult result, Money money) {
        ViewUtils.printLine(WINNING_STATISTICS_INFORMATION);

        Arrays.stream(LottoTier.values())
                .forEach(tier -> {
                    int tierCount = result.getTierCount(tier);
                    ViewUtils.printLine(String.format(MATCH_RESULT_INFORMATION, tier.getMatchedNumberCount(), tier.getPrize(), tierCount));
                });

        printYield(result, money);
    }

    private void printYield(LottoResult result, Money money) {
        ViewUtils.printLine(String.format(YIELD_INFORMATION, result.getYield(money)));
    }
}
