package lotto.domain;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final String ERROR_LOTTO_NUMBER = "로또 번호는 6개여야 합니다.";

    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        validate(lotto);
        this.lotto = lotto;
    }

    private void validate(Set<LottoNumber> lottoNumber) {
        if (lottoNumber.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ERROR_LOTTO_NUMBER);
        }
    }

    public int matchWinningnumbers(Lotto winningNumber) {
        return (int) lotto.stream()
            .filter(lottoNumber -> lottoNumber.isWinningNumber(lottoNumber, winningNumber))
            .count();
    }

    public Set<LottoNumber> getLotto() {
        return Collections.unmodifiableSet(lotto);
    }

}
