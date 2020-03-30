package lotto.domain.item;

import lotto.exception.ValidLottoException;

import java.util.List;
import java.util.Objects;

public class WinLottoTicket extends Lotto {
    public WinLottoTicket(List<LottoNumber> numbers) {
        super(numbers);
    }

//    private final int bonus;

//    public WinLottoTicket(List<Integer> numbers, int bonus) {
//        super(numbers);
//        validateBonusNumber(numbers, bonus);
//        this.bonus = bonus;
//    }
//
//    private void validateBonusNumber(List<Integer> numbers, int bonus) {
//        if (numbers.contains(bonus)) {
//            throw new ValidLottoException("당첨 번호와 보너스 번호가 중복됩니다.");
//        }
//    }
//
//    public int getBonus() {
//        return bonus;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        if (!super.equals(o)) return false;
//        WinLottoTicket that = (WinLottoTicket) o;
//        return bonus == that.bonus;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(super.hashCode(), bonus);
//    }
}
