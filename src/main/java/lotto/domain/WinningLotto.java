package lotto.domain;

import lotto.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private Lotto winningLotto;

    public WinningLotto(final String value) {
        this(StringUtils.split(value, ","));
    }

    public WinningLotto(final List<String> values) {
        this.winningLotto = new Lotto(values.stream()
                .map(Number::new)
                .collect(Collectors.toList()));
    }

    public boolean contains(Number number) {
        return winningLotto.numbers().
                contains(number);
    }
}
