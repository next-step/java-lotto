package study.lotto.domain;

import study.lotto.domain.type.LottoMatch;
import study.lotto.exception.LottoException;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static study.lotto.util.Constants.*;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    WinningLotto(final Lotto winningLotto, final LottoNumber bonusNumber) {
        if(winningLotto.contains(bonusNumber)) {
            throw new LottoException(GUIDE_ERR_DONT_CONTAINS_BONUS_NUMBER);
        }
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(final String winningLotto) {
        return new WinningLotto(parseLotto(winningLotto), null);
    }

    public static WinningLotto of(final String winningLotto, final LottoNumber bonusNumber) {
        return new WinningLotto(parseLotto(winningLotto), bonusNumber);
    }

    private static Lotto parseLotto(final String winningLotto) {
        String[] split = parseSplit(winningLotto);
        return Lotto.of(Arrays.stream(split)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    private static String[] parseSplit(final String winningLotto) {
        return winningLotto.replaceAll(SPACIAL_CHARACTER_SPACE, WHITE_SPACE)
                .split(SPLIT_DELIMITER);
    }

    public LottoMatch match(final Lotto lotto) {
        long count = winningLotto.match(lotto);
        boolean hasBonus = lotto.contains(bonusNumber);
        return LottoMatch.of(count, hasBonus);
    }

    public long winningReward(final Lotto lotto) {
        return match(lotto).getWinningReward();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningLotto)) return false;
        final WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto)
                && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusNumber);
    }

    @Override
    public String toString() {
        return String.format("%s %s", winningLotto, bonusNumber);
    }
}
