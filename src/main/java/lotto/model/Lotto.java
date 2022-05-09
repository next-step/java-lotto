package lotto.model;

import lotto.enums.Grade;
import lotto.exception.BonusContainWinningResultException;
import lotto.exception.LottoLengthException;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class Lotto {

    private static final int DEFAULT_LOTTO_SIZE = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<Integer> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = Lotto.convertLottoNumberToInteger(lottoNumbers);
    }

    private static Set<LottoNumber> convertLottoNumberToInteger(Set<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public static Lotto from(Set<Integer> winnerNumbers) {
        return new Lotto(winnerNumbers);
    }

    private void validate(Set<Integer> lottoNumbers) {
        if (DEFAULT_LOTTO_SIZE != lottoNumbers.size()) {
            throw new LottoLengthException();
        }
    }


    public Set<Integer> numbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::currentNumber)
                .collect(Collectors.toSet());
    }


    public Grade matchCount(Set<Integer> winningLotto, int bonusNumber) {
        int count = 0;
        for (int lottoNumber : this.numbers()) {
            count = lottoMatchCount(winningLotto, count, lottoNumber);
        }
        return Grade.valueOf(count, getBonusCheck(winningLotto, bonusNumber));
    }

    private int lottoMatchCount(Set<Integer> winningLotto, int count, int lottoNumber) {
        if (winningLotto.contains(lottoNumber)) {
            count++;
        }
        return count;
    }

    private boolean getBonusCheck(Set<Integer> winningLotto, int bonusNumber) {
        bonusContainValidate(winningLotto, bonusNumber);
        return this.numbers().contains(bonusNumber);
    }

    private void bonusContainValidate(Set<Integer> winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new BonusContainWinningResultException(bonusNumber);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}