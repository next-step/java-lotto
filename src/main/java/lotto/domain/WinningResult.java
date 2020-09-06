package lotto.domain;

import lotto.context.Error;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningResult {
    private static final int DEFAULT_BONUS_INDEX = 0;

    private final LottoPaper winningPaper;
    private final LottoPaper bonusPaper;

    public WinningResult(String winningLottoNumbers, String bonusNumber) {
        validWinningResult(winningLottoNumbers);
        winningPaper = new LottoPaper(Arrays.stream(winningLottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNum::of)
                .collect(Collectors.toList()));
        bonusPaper = new LottoPaper(Arrays.asList(LottoNum.of(bonusNumber)));
    }

    private void validWinningResult(String winningLottoNumbers) {
        if (winningLottoNumbers == null || "".equals(winningLottoNumbers)) {
            throw new IllegalArgumentException(Error.ERROR_INPUT_NULL.getMsg());
        }
    }

    public WinningTable makeWinningTable(List<LottoPaper> lottoPapers) {
        WinningTable winningTable = new WinningTable();

        lottoPapers.forEach(lottoPaper -> {
            winningTable.incrementMatchCountResult(getMatchCount(lottoPaper), hasBonus(lottoPaper));
        });
        return winningTable;
    }

    int getMatchCount(LottoPaper lottoPaper) {
        return lottoPaper.getMatchCount(winningPaper.getLottoNumberToIntegerList());
    }

    boolean hasBonus(LottoPaper lottoPaper) {
        return lottoPaper.isContain(bonusPaper.getLottoNumbers().get(DEFAULT_BONUS_INDEX));
    }
}
