package lotto.domain;

import lotto.util.Parser;
import lotto.util.Splitter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validate(lotto, bonusNumber);

        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto createWinningNumbers(String inputString, int bonusNumber) {
        List<Integer> winningNumbers = Arrays.stream(Splitter.splitString(inputString))
                .map(Parser::parseInteger)
                .collect(Collectors.toList());

        return new WinningLotto(new Lotto(winningNumbers), new LottoNumber(bonusNumber));
    }

    public int match(Lotto userLotto) {
        return this.lotto.matchCount(userLotto);
    }

    public boolean isBonusWinning(Lotto userLotto) {
        return userLotto.isContain(this.bonusNumber);
    }

    private void validate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException("기존 당첨번호와 중복된 번호는 입력할 수 없습니다.");
        }
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
