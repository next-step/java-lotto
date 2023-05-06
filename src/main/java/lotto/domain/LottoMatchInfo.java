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

    public static LottoMatchInfo countMatchingNumbers(LottoNumber lottoNumber, List<Integer> winningNumbers) {
        List<Integer> numbers = lottoNumber.getNumbers();

        int count = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        return new LottoMatchInfo(count, false);
    }

    public static LottoMatchInfo countMatchingNumbers(LottoNumber lottoNumber, List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> numbers = lottoNumber.getNumbers();

        int count = (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        boolean bonusMatch = numbers.contains(bonusNumber);

        return new LottoMatchInfo(count, bonusMatch);
    }

}
