package lotto.model;

import java.util.*;

import static lotto.model.LottoFactory.LOTTO_MAX_LENGTH;

public class Lotto {
    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        validation(lotto);
        this.lotto = lotto;
    }

    public Rank matchingRank(Lotto winningLotto) {
        return Rank.findRank(counting(winningLotto));
    }

    public Set<LottoNumber> getLotto() {
        return Collections.unmodifiableSet(lotto);
    }

    private void validation(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_MAX_LENGTH) {
            throw new IllegalArgumentException("로또의 개수를 확인해주세요");
        }
    }

    private int counting(Lotto winningLotto) {
        return (int) lotto.stream()
                .flatMap(lottoNumber -> winningLotto.lotto.stream()
                        .filter(lottoNumber1 -> lottoNumber1.isWinningNumber(lottoNumber)))
                .count();
    }

    boolean isSecondRank(LottoNumber bonusLotto) {
        return lotto.stream()
                .anyMatch(lottoNumber ->  lottoNumber.isMatchBonusNum(bonusLotto));
    }
}
