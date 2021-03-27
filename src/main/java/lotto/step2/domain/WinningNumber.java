package lotto.step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinningNumber {

    private static final LottoGenerator lottoGenerator = LottoGenerator.getInstance();
    private final Lotto winningNumbers;

    private WinningNumber(final String winningNumbers) {
        this.winningNumbers = Lotto.of(
                lottoGenerator.generateAppointedLotto(winningNumbers)
        );
    }

    public static WinningNumber of(final String winningNumbers) {
        return new WinningNumber(winningNumbers);
    }

    public long getLottoMatchCount(Lotto lotto) {
        List<Integer> list = lotto.stream().collect(Collectors.toList());
        return winningNumbers.stream()
                .filter(i -> list.contains(i))
                .count();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        WinningNumber that = (WinningNumber) object;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
