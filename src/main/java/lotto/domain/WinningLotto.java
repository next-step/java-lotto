package lotto.domain;

import lotto.util.Parser;
import lotto.util.Splitter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLotto {

    private final Lotto lotto;

    public WinningLotto(Lotto winningNumbers) {
        this.lotto = winningNumbers;
    }

    public static WinningLotto createWinningNumbers(String inputString) {
        List<Integer> winningNumbers = Arrays.stream(Splitter.splitString(inputString))
                .map(Parser::parseInteger)
                .collect(Collectors.toList());

        return new WinningLotto(new Lotto(winningNumbers));
    }

    public int match(Lotto userLotto) {
        return this.lotto.matchCount(userLotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
