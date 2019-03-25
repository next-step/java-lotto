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

    public ResultView viewResults(final LottoPaper lottoPaper, final String winningNumber, final int bonusNumber) {
        final WinningStatistics statistics = lottoPaper.viewResults(getWinningNumber(winningNumber, bonusNumber));
        return new ResultView(new WinningStatisticsView(statistics.get()), statistics.getRoi());
    }

    private int getNumberOfLottoToPurchase(final int amount) {
        return (int) Money.from(amount)
                .divide(Lotto.PRICE)
                ;
    }

    private WinningNumber getWinningNumber(final String lottoNumbers, final int bonusNumber) {
        return new WinningNumber(getLottoNumbers(lottoNumbers), LottoNumber.from(bonusNumber));
    }

    private LottoNumbers getLottoNumbers(final String lottoNumbers) {
        return new LottoNumbers(
                Arrays.stream(lottoNumbers.split(NUMBER_SEPARATOR))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList())
        );
    }
}
