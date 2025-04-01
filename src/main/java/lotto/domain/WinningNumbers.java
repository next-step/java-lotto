package lotto.domain;

import java.util.Set;

public class WinningNumbers {

    private final Set<Integer> numbers;
    private final int bonusNumber;

    public WinningNumbers(Set<Integer> numbers, int bonusNumber) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
        }
        this.numbers = numbers;

        if (this.numbers.contains(bonusNumber)) {
            throw new IllegalStateException("보너스 볼은 당첨 번호와 중복될 수 없습니다: " + bonusNumber);
        }

        this.bonusNumber = bonusNumber;
    }

    public LottoPrize determineLottoPrize(LottoTicket ticket) {
        int matchCount = ticket.matchCountWith(numbers);
        boolean hasBonusNumber = ticket.hasBonusNumber(bonusNumber);
        return LottoPrize.valueOf(matchCount, hasBonusNumber);
    }

//    public void setBonusNumber(int bonusNumber) {
//        if (numbers.contains(bonusNumber)) {
//            throw new IllegalStateException("보너스 볼은 당첨 번호와 중복될 수 없습니다: " + bonusNumber);
//        }
//
//        this.bonusNumber = bonusNumber;
//    }

    public int size() {
        return numbers.size();
    }
}
