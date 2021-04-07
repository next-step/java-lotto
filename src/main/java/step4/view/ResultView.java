package step4.view;

import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;

public final class ResultView {

    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static final String LOTTO_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String LOTTO_WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n";
    private static final String PERFORATION = "---------\n";
    private static final String CORRECT_WINNING_LOTTO_MESSAGE = "%d개 일치 (%d)원 - %d개\n";
    private static final String CORRECT_WINNING_LOTTO_MESSAGE_IN_SECOND = "%d개 일치, 보너스 볼 일치(%d)원 - %d개\n";
    private static final String TOTAL_YIELD_ANALYSIS_MESSAGE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";

    private static final String PREFIX = "[";
    private static final String SUFFIX = "]\n";
    private static final String DELIMITER = ", ";

    private static final double DIGIT_FORMAT = 100.0;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static class ResultViewHolder {
        public static final ResultView instance = new ResultView();
    }

    private ResultView() {
    }

    public static final ResultView getInstance() {
        return ResultViewHolder.instance;
    }

    public final void printLottoList(List<Lotto> lottos) {
        STRING_BUILDER.append(String.format(LOTTO_COUNT_MESSAGE, lottos.size()));
        STRING_BUILDER.append(joinLottoNumbers(lottos));
        System.out.println(STRING_BUILDER.toString());
    }

    private final StringBuilder joinLottoNumbers(List<Lotto> lottos) {
        StringBuilder joinBuilder = new StringBuilder();
        lottos.stream()
                .map(Lotto::getLotto)
                .map(this::getEachLottoString)
                .forEach(joinBuilder::append);
        return joinBuilder;
    }

    private final String getEachLottoString(Set<LottoNumber> lottoNumbers) {
        return getJoinedLotto(setToSortedList(lottoNumbers));
    }

    private final List<LottoNumber> setToSortedList(Set<LottoNumber> lottoNumbers) {
        List<LottoNumber> lottoNumberList = new ArrayList<>(lottoNumbers);
        Collections.sort(lottoNumberList);
        return lottoNumberList;
    }

    private final String getJoinedLotto(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }

}
