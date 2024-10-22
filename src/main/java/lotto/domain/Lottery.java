package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumberGenerator.LOTTO_NUMBERS_SIZE;

public class Lottery {
    private final Set<LottoNumber> lottoNumbers;

    public Lottery(Set<Integer> lottoNumbers) {
        validateLottoNumberSize(lottoNumbers);

        this.lottoNumbers = lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public int countWinningNumbers(Lottery winningNumbers) {
        Set<LottoNumber> equalNumbers = new HashSet<>(this.lottoNumbers);
        equalNumbers.retainAll(winningNumbers.lottoNumbers);

        return equalNumbers.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public List<Integer> getSortedLottoNumbers() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .sorted()
                .collect(Collectors.toList());
    }

    public LottoResult createLottoResult(Lottery winningNumbers, LottoNumber lottoNumber) {
        int equalNumberCount = countWinningNumbers(winningNumbers);
        boolean hasBonusNumber = hasBonusNumber(lottoNumber);

        return new LottoResult(hasBonusNumber, equalNumberCount);
    }

    private void validateLottoNumberSize(Set<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(String.format("로또번호는 %d개 이어야 합니다", LOTTO_NUMBERS_SIZE));
        }
    }

    private boolean hasBonusNumber(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
