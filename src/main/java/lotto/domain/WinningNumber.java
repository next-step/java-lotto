package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Rank;

public class WinningNumber {

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonus;

    public WinningNumber(List<LottoNumber> lottoNumbers, LottoNumber bonus) {
        this.lottoNumbers = lottoNumbers;
        this.bonus = bonus;
    }

    public Rank compareTo(List<Integer> targetLotto) {
        List<Integer> winningNumbers = lottoNumbers.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());

        int matchCount = targetLotto.stream()
            .filter(lottoNumber -> isContain(winningNumbers, lottoNumber))
            .collect(Collectors.toList())
            .size();

        return getRank(targetLotto, matchCount);
    }

    private Rank getRank(List<Integer> targetLotto, int matchCount) {
        boolean bonusBall = false;
        if (matchCount == 5) {
            bonusBall = isContain(targetLotto, bonus.getNumber());
        }
        return Rank.find(matchCount, bonusBall);
    }

    private boolean isContain(List<Integer> targetLotto, int lottoNumber) {
        return targetLotto.contains(lottoNumber);
    }
}
