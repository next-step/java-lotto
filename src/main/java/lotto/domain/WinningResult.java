package lotto.domain;

import lotto.context.Error;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningResult {
    private static final int DEFAULT_BONUS_INDEX = 0;

    private final LottoPaper winningPaper;
    private final LottoNum bonusNumber;

    public WinningResult(String winningLottoNumbers, String bonusNumber) {
        validWinningResult(winningLottoNumbers);
        winningPaper = new LottoPaper(Arrays.stream(winningLottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNum::of)
                .collect(Collectors.toList()));
        this.bonusNumber = LottoNum.of(bonusNumber);
    }

    private void validWinningResult(String winningLottoNumbers) {
        if (winningLottoNumbers == null || "".equals(winningLottoNumbers)) {
            throw new IllegalArgumentException(Error.ERROR_INPUT_NULL.getMsg());
        }
    }

    public WinningTable makeWinningTable(List<LottoPaper> lottoPapers) {
        WinningTable winningTable = new WinningTable();

        lottoPapers.forEach(lottoPaper -> {
            winningTable.incrementMatchCountResult(getMatchCount(lottoPaper), hasBonusBall(lottoPaper));
        });
        return winningTable;
    }

    int getMatchCount(LottoPaper lottoPaper) {
        return lottoPaper.getMatchCount(winningPaper.getLottoNumberToIntegerList());
    }

    boolean hasBonusBall(LottoPaper lottoPaper) {
        return lottoPaper.isContain(getBonusNumber());
    }

    public LottoNum getBonusNumber() {
        return bonusNumber;
    }
}
