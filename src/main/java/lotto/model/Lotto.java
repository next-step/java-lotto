package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

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

    public static Lotto toLottoNumber(List<Integer> testLotto) {
        return new Lotto(lottoNumbers(testLotto));
    }

    public static Set<LottoNumber> toLottoSet(List<Integer> testLotto) {
        return lottoNumbers(testLotto);
    }

    private static Set<LottoNumber> lottoNumbers(List<Integer> testLotto) {
        return testLotto.stream()
                .map(Integer -> LottoNumber.cache().get(Integer))
                .collect(Collectors.toSet());
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
