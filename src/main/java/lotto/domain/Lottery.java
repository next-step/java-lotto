package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lottery {
    private final Set<Integer> lottoNumbers;

    public Lottery(Set<Integer> lottoNumbers) {
        LottoNumberValidator.validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public int countWinningNumbers(Lottery winningNumbers) {
        Set<Integer> equalNumbers = new HashSet<>(this.lottoNumbers);
        equalNumbers.retainAll(winningNumbers.lottoNumbers);

        return equalNumbers.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public List<Integer> getSortedLottoNumbers() {
        return lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public LottoResult createLottoResult(Lottery winningNumbers, BonusNumber bonusNumber) {
        int equalNumberCount = countWinningNumbers(winningNumbers);
        boolean hasBonusNumber = hasBonusNumber(bonusNumber.getBonusNumber());

        return new LottoResult(hasBonusNumber, equalNumberCount);
    }

    private boolean hasBonusNumber(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }
}
