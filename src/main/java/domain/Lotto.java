package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMBER = 6;

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 6개의 다른 값 이여야 합니다.");
        }
    }

    public static Lotto auto() {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        while (lottoNumbers.size() != 6) {
            lottoNumbers.add(LottoNumber.getRandomLottoNumber());
        }
        return new Lotto(lottoNumbers);
    }

    public boolean isContainBonus(WinningLotto winningLotto) {
        return lottoNumbers.stream()
                .anyMatch(winningLotto::isMatchBonusNumber);
    }

    public Set<LottoNumber> getWinningNumbers(WinningLotto lotto) {
        return lottoNumbers.stream()
                .filter(lotto::isContainInWinningNumber)
                .collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(",")) + "]";
    }
}
