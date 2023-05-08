package lotto.domain;

import java.util.List;

public class LottoMatchInfo {
    private final int matchCount;
    private final boolean bonusMatch;

    private LottoMatchInfo(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public static LottoMatchInfo countMatchingNumbers(LottoNumber lottoNumber,
                                                      List<LottoAvailableNumber> winningNumbers,
                                                      LottoAvailableNumber bonusNumber) {
        List<LottoAvailableNumber> numbers = lottoNumber.getLottoNumbers();

        int count = (int) numbers.stream()
                .filter(number -> winningNumbers.stream()
                        .anyMatch(winningNumber -> winningNumber.getNumber() == number.getNumber()))
                .count();

        boolean bonusMatch = numbers.contains(bonusNumber);

        return new LottoMatchInfo(count, bonusMatch);
    }

}
