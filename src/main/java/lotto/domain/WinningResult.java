package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningResult {
    private final LottoPaper winningPaper;

    public WinningResult(String winningLottoNumbers) {
        winningPaper = new LottoPaper(Arrays.stream(winningLottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(integer -> new LottoNum(integer))
                .collect(Collectors.toList()));
    }

    public List<Integer> getWinninLottoNumberToIntegerList() {
        return winningPaper.getLottoNumbers().stream()
                .map(LottoNum::getLottoNum)
                .collect(Collectors.toList());
    }
}
