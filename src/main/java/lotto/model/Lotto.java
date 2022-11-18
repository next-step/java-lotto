package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.model.LottoFactory.LOTTO_MAX_LENGTH;
import static lotto.model.Rank.*;

public class Lotto {
    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        validation(lotto);
        this.lotto = lotto;
    }



    public Rank rank(WinningLotto winningLotto) {
        Rank rank = findRank(counting(winningLotto));
        return rank.checkBonus(winningLotto, lotto);
    }

    public boolean isMatch(LottoNumber buyLottoNumber) {
        return lotto.stream()
                .anyMatch(winningNum -> winningNum.isMatchNumber(buyLottoNumber));
    }

    public Set<LottoNumber> getLotto() {
        return Collections.unmodifiableSet(lotto);
    }

    private void validation(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_MAX_LENGTH) {
            throw new IllegalArgumentException("로또의 개수를 확인해주세요");
        }
    }

    private int counting(WinningLotto winningLotto) {
        return (int) lotto.stream()
                .filter(winningLotto::isMatch)
                .count();
    }
}
