package lotto.model;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class WinningLotto {
    private static final String DELIMITER = ", ";

    private final Lotto winningLotto;

    private WinningLotto(final Lotto lotto) {
        this.winningLotto = lotto;
    }

    public static WinningLotto from(final String winningNumber) {
        Objects.requireNonNull(winningNumber, "winningNumbers must be not null.");
        return new WinningLotto(Lotto.from(parseIntegerList(winningNumber)));
    }

    private static Set<Integer> parseIntegerList(final String winningNumber) {
        return stream(winningNumber.split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());
    }

    public boolean isSizeValid() {
        return winningLotto.isSizeValid();
    }

    public int matchCount(final Lotto lotto) {
        return winningLotto.matchCount(lotto);
    }
}
