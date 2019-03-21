package lotto.application;

import lotto.domain.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
    private static final String NUMBER_SEPARATOR = ", ";

    public LottoPaper issue(final int amount) {
        return new LottoPaper(
                IntStream.rangeClosed(1, getNumberOfLottoToPurchase(amount))
                        .mapToObj(time -> Lotto.automatic())
                        .collect(Collectors.toList())
        );
    }

    public ResultView viewResults(final LottoPaper lottoPaper, final String winningNumber) {
        final WinningStatistics statistics = lottoPaper.viewResults(getLottoNumbers(winningNumber));
        return new ResultView(new WinningStatisticsView(statistics.get()), statistics.getRoi());
    }

    private int getNumberOfLottoToPurchase(final int amount) {
        return (int) Money.from(amount)
                .divide(Lotto.PRICE)
                ;
    }

    private LottoNumbers getLottoNumbers(final String lottoNumbers) {
        return new LottoNumbers(
                Arrays.stream(lottoNumbers.split(NUMBER_SEPARATOR))
                        .map(Integer::valueOf)
                        .map(LottoNumber::from)
                        .collect(Collectors.toList())
        );
    }
}
