package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Rank;

public class WinningNumber {

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonus;

    public WinningNumber(List<LottoNumber> numbers, LottoNumber bonus) {
        this.lottoNumbers = numbers;
        this.bonus = bonus;
    }

    public Rank compareTo(List<Integer> targetLotto) {
        int matchCount = 0;
        boolean bonusBall = false;

        List<Integer> winningNumbers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        for (Integer lottoNumber : targetLotto) {
            if (isContain(winningNumbers, lottoNumber)) {
                matchCount++;
            }
        }

        if (matchCount == 5) {
            bonusBall = isContain(targetLotto, bonus.getNumber());
        }
        return Rank.find(matchCount, bonusBall);
    }

    private boolean isContain(List<Integer> targetLotto, int lottoNumber) {
        return targetLotto.contains(lottoNumber);
    }
}
