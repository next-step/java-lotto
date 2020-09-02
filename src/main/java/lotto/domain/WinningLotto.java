package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Set<LottoNumber> winningNumbers;

    private WinningLotto(Set<LottoNumber> lottoNumbers) {
        this.winningNumbers = lottoNumbers;
    }

    public static WinningLotto of(List<Integer> numbers) {
        return new WinningLotto(numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet()));
    }

    public Set<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
