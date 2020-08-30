package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningPaper {
    private final List<LottoNum> winningNumbers;

    WinningPaper(String winningLottoNumbers) {
        List<LottoNum> numberList = makeNmbersAsList(winningLottoNumbers);
        this.winningNumbers = numberList;
    }

    private List makeNmbersAsList(String winningLottoNumbers) {
        return Arrays.stream(winningLottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(integer -> new LottoNum(integer))
                .collect(Collectors.toList());
    }

    public List<LottoNum> getWinningNumbers() {
        return winningNumbers;
    }

    public List<Integer> getWinningNumbersToIntegerList() {
        return winningNumbers.stream()
                .map(LottoNum::getLottoNum)
                .collect(Collectors.toList());
    }
}
