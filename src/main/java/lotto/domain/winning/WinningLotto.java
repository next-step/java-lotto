package lotto.domain.winning;

import lotto.domain.number.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLotto {

    private final LottoNumbers winningLottoNumbers;

    public WinningLotto(String winningNumbers) {
        this.winningLottoNumbers = createWinningNumbers(winningNumbers);
    }

    private LottoNumbers createWinningNumbers(String winningNumberString) {
        List<Integer> winningNumbers = Arrays.stream(winningNumberString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return LottoNumbers.manualLottoNumber(winningNumbers);
    }

    public LottoNumbers getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public int matchCount(LottoNumbers lottoNumbers) {
        return Math.toIntExact(
                this.winningLottoNumbers.getNumbers()
                        .stream()
                        .filter(winningNumber -> lottoNumbers.getNumbers().contains(winningNumber))
                        .count()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningLotto)) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLottoNumbers, that.winningLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLottoNumbers);
    }
}
