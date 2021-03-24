package lotto.step2.domain;

import lotto.step2.utils.LottoUtils;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class WinningNumber {

    private final Set<Integer> winningNumbers;

    private WinningNumber(final Set<Integer> winningNumbers) {
        LottoUtils.validation(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumber of(final String[] winningNumbers) {
        return new WinningNumber(
                new TreeSet<Integer>(Arrays.stream(winningNumbers)
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toSet())
                )
        );
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
