package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(Lotto lotto, LottoNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto, LottoNumber bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();
        if (numbers.contains(bonusNumber.getValue())) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public Rank match(Lotto userLotto) {
        int matchCount = countMatch(userLotto);
        boolean matchBonus = hasMatchBonus(userLotto, matchCount);
        return Rank.valueOf(matchCount, matchBonus);
    }

    private int countMatch(Lotto userLotto) {
        List<Integer> userNumbers = userLotto.getNumbers();
        List<Integer> winningNumbers = lotto.getNumbers();
        int count = 0;
        for (Integer number : userNumbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasMatchBonus(Lotto userLotto, int matchCount) {
        if (matchCount != 5) {
            return false;

        }
        List<Integer> userNumbers = userLotto.getNumbers();
        for (Integer number : userNumbers) {
            if (number == bonusNumber.getValue()) {
                return true;

            }

        }
        return false;

    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public boolean containsInLotto(LottoNumber number) {
        List<Integer> numbers = lotto.getNumbers();
        return numbers.contains(number.getValue());
    }

    public boolean matchBonus(LottoNumber number) {
        return bonusNumber.equals(number);
    }
}
