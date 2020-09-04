package lotto.domain;

import lotto.context.Error;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WinningResult {
    private final LottoPaper winningPaper;
    private LottoNum bonusNum;

    public WinningResult(String winningLottoNumbers) {
        validWinningResult(winningLottoNumbers);
        winningPaper = new LottoPaper(Arrays.stream(winningLottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNum::of)
                .collect(Collectors.toList()));
    }

    private void validWinningResult(String winningLottoNumbers) {
        if (winningLottoNumbers == null || "".equals(winningLottoNumbers)) {
            throw new IllegalArgumentException(Error.ERROR_INPUT_NULL.getMsg());
        }
    }

    public List<Integer> getWinningLottoNumberToIntegerList() {
        return winningPaper.getLottoNumbers().stream()
                .map(LottoNum::getLottoNum)
                .collect(Collectors.toList());
    }

    public void setBonusNum(LottoNum lottoNum) {
        this.bonusNum = lottoNum;
    }

    public WinningTable makeWinningTable(List<LottoPaper> lottoPapers) {
        WinningTable winningTable = new WinningTable();

        lottoPapers.forEach(lottoPaper -> {
            winningTable.setAutoIncrementMatchCountResult(lottoPaper.getMatchCount(getWinningLottoNumberToIntegerList()),
                    isBonus(lottoPaper));
        });
        return winningTable;
    }

    private boolean isBonus(LottoPaper lottoPaper) {
        return lottoPaper.isContain(Optional.ofNullable(bonusNum.getLottoNum())
                .get());
    }
}
