package lotto;

import java.util.List;

public class BonusNumber {

    private final int number;

    private BonusNumber(int number) {
        this.number = number;
    }

    public static BonusNumber newNumber(int bonusNumber) {
        if (bonusNumber > LottoTotalNumberUtils.LOTTO_NUMBER_MAXIMUM) {
            throw new IllegalArgumentException("보너스 번호는 45보다 클 수 없습니다.");
        }

        if (bonusNumber < LottoTotalNumberUtils.LOTTO_NUMBER_MINIMUM) {
            throw new IllegalArgumentException("보너스 번호는 1보다 작을 수 없습니다.");
        }

        return new BonusNumber(bonusNumber);
    }

    public boolean isMatchBonus(int countOfMatch, List<Integer> ticketNumbers) {
        if (countOfMatch == Rank.SECOND.getCountOfMatch()) {
            return ticketNumbers.contains(number);
        }

        return false;
    }

    public int getNumber() {
        return number;
    }
}
