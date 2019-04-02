package lotto.application;

import lotto.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoService {
    private static final String NUMBER_SEPARATOR = ", ";
    private static final int ROI_SCALE = 2;

    public LottoPaper issue(final int amount, final List<String> manualNumbers) {
        return LottoPaper.issue(Money.from(amount), getLottoNumbers(manualNumbers));
    }

    public ResultView viewResults(final LottoPaper lottoPaper, final String winningNumber, final int bonusNumber) {
        final WinningStatistics statistics = lottoPaper.viewResults(getWinningNumber(winningNumber, bonusNumber));
        return new ResultView(new WinningStatisticsView(statistics.get()), statistics.getRoi(ROI_SCALE).doubleValue());
    }

    private WinningNumber getWinningNumber(final String lottoNumbers, final int bonusNumber) {
        return new WinningNumber(getLottoNumbers(lottoNumbers), LottoNumber.from(bonusNumber));
    }

    private List<LottoNumbers> getLottoNumbers(final List<String> manualNumbers) {
        return manualNumbers.stream()
                .map(this::getLottoNumbers)
                .collect(Collectors.toList())
                ;
    }

    private LottoNumbers getLottoNumbers(final String lottoNumbers) {
        return new LottoNumbers(
                Arrays.stream(lottoNumbers.split(NUMBER_SEPARATOR))
                        .mapToInt(Integer::valueOf)
                        .toArray()
        );
    }
}
