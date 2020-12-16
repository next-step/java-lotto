package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.LottoResult;
import step2.domain.LottoTier;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OutputView {
    private static final String OUTPUT_BUY_COUNT_MESSAGE = "%s개를 구매했습니다.";
    private static final String OUTPUT_WINNING_STATISTICS_MESSAGE = "당첨 통계\n---------";
    private static final String OUTPUT__RESULT_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String OUTPUT_YIELD_MESSAGE = "총 수익률은 %.2f 입니다.";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String LOTTO_NUMBER_PREFIX = "[";
    private static final String LOTTO_NUMBER_POSTFIX = "]";

    private final ViewUtils viewUtils;

    public OutputView() {
        this.viewUtils = new ViewUtils();
    }

    public void printLottos(List<Lotto> lottos) {
        viewUtils.printLine(String.format(OUTPUT_BUY_COUNT_MESSAGE, lottos.size()));

        StringBuilder stringBuilder = new StringBuilder();

        for(Lotto lotto : lottos) {
            stringBuilder.setLength(0);

            Set<LottoNumber> lottoNumbers = lotto.getValue();
            stringBuilder.append(getLottoNumbersString(lottoNumbers));
            viewUtils.printLine(stringBuilder.toString());
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
        viewUtils.printLine(OUTPUT_WINNING_STATISTICS_MESSAGE);

        Arrays.stream(LottoTier.values())
                .forEach(tier -> {
                    int tierCount = result.getTierCount(tier);
                    viewUtils.printLine(String.format(OUTPUT__RESULT_MESSAGE, tier.getMatchingCount(), tier.getPrize(), tierCount));
                });

        viewUtils.printLine(String.format(OUTPUT_YIELD_MESSAGE, result.getYield(money)));
    }
}
