package lotto.application;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPaper;
import lotto.domain.WinningStatistics;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final String NUMBER_SEPARATOR = ", ";

    public LottoPaper issue(final int amount) {
        final int numberOfLottoToPurchase = amount / Lotto.PRICE;
        return new LottoPaper(
                IntStream.rangeClosed(1, numberOfLottoToPurchase)
                        .mapToObj(time -> Lotto.automatic())
                        .collect(Collectors.toList())
        );
    }

    public ResultView viewResults(final LottoPaper lottoPaper, final String winningNumber) {
        final WinningStatistics statistics = lottoPaper.viewResults(getLottoNumbers(winningNumber));
        return new ResultView(new WinningStatisticsView(statistics.get()), statistics.getRoi());
    }

    private LottoNumbers getLottoNumbers(final String lottoNumbers) {
        return new LottoNumbers(
                Arrays.stream(lottoNumbers.split(NUMBER_SEPARATOR))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList())
        );
    }
}
