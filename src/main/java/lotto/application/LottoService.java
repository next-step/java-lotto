package lotto.application;

import lotto.domain.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {
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
        return new WinningNumber(new LottoNumbers(lottoNumbers), LottoNumber.from(bonusNumber));
    }
}
