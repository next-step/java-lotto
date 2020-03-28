package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.Lottos;

import java.util.List;

public class ResultView {
    private static final String LOTTO_COUNT_INFORMATION = "%s개를 구매했습니다.";
    private static final String WINNING_STATISTICS_INFORMATION = "당첨 통계\n---------";
    private static final String MATCH_FIRST_INFORMATION = "6개 일치 (2000000000원)- %s개";
    private static final String MATCH_SECOND_INFORMATION = "5개 일치 (150000원)- %s개";
    private static final String MATCH_THIRD_INFORMATION = "4개 일치 (50000원)- %s개";
    private static final String MATCH_FOURTH_INFORMATION = "3개 일치 (5000원)- %s개";
    private static final String YIELD_INFORMATION = "총 수익률은 %.2f 입니다.";
    private static final String LOTTO_NUMBER_PREFIX = "[";
    private static final String LOTTO_NUMBER_POSTFIX = "]";
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private void printLine(String line) {
        System.out.println(line);
    }

    public void showLottos(Lottos lottos, int count) {
        printLine(String.format(LOTTO_COUNT_INFORMATION, count));
        printLottoNumbers(lottos);
    }

    private void printLottoNumbers(Lottos lottos) {
        StringBuilder builder = new StringBuilder();

        for(Lotto lotto : lottos.getValue()) {
            builder.setLength(0);
            builder.append(LOTTO_NUMBER_PREFIX);

            List<LottoNumber> lottoNumbers = lotto.getValue();
            appendLottoNumbers(builder, lottoNumbers);

            builder.append(LOTTO_NUMBER_POSTFIX);
            printLine(builder.toString());
        }
    }

    private void appendLottoNumbers(StringBuilder builder, List<LottoNumber> lottoNumbers) {
        for(int i = 0; i < lottoNumbers.size(); i++) {
            appendDelimiter(builder, i);
            builder.append(Integer.toString(lottoNumbers.get(i).getValue()));
        }
    }

    private void appendDelimiter(StringBuilder builder, int i) {
        if(i != 0) {
            builder.append(LOTTO_NUMBER_DELIMITER);
        }
    }
}
