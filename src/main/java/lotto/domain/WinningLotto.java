package lotto.domain;

import lotto.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private Lotto winningLotto;
    private final Number bonusNumber;

    public WinningLotto(final String value, final String bonusValue) {
        this(StringUtils.split(value, ","), bonusValue);
    }

    public WinningLotto(final List<String> values, final String bonusValue) {
        this.winningLotto = new Lotto(values.stream()
                .map(Number::new)
                .collect(Collectors.toList()));
        this.bonusNumber = new Number(bonusValue);
        bonusValidation();
    }

    public void bonusValidation() {
        if (contains(bonusNumber))
            throw new IllegalArgumentException("보너스 번호는 지난 담청 번호 6개와 같을 수 없습니다.");
    }

    public Number bonusNumber() {
        return bonusNumber;
    }

    public boolean contains(Number number) {
        return winningLotto.numbers()
                .contains(number);
    }
}
