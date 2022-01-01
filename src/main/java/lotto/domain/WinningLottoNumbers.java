package lotto.domain;

import java.util.List;

public class WinningLottoNumbers {

    private final LottoNumbers winnings;
    private final LottoNumber bonus;

    public WinningLottoNumbers(LottoNumbers winnings, LottoNumber bonus) {
        verify(winnings, bonus);
        this.winnings = winnings;
        this.bonus = bonus;
    }

    public Rank rank(LottoNumbers numbers) {
        return Rank.calculate(winnings.matches(numbers), numbers.contains(bonus));
    }

    public static WinningLottoNumbers of(List<LottoNumber> values, LottoNumber bonus) {
        return new WinningLottoNumbers(LottoNumbers.from(values), bonus);
    }

    private void verify(LottoNumbers numbers, LottoNumber number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException("보너스볼의 번호는 당첨번호와 중복된 번호일 수 없습니다.");
        }
    }
}
