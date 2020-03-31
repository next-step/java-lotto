package lotto.domain.item;

import lotto.exception.ValidLottoException;

public class WinLottoTicket extends Lotto {

    private static final String NULL_PARAM_ERROR_MESSAGE = "매개변수:null";

    private final LottoNumber bonus;

    public WinLottoTicket(LottoNumbers numbers, LottoNumber bonus) {
        super(numbers);
        if (bonus == null) {
            throw new ValidLottoException(NULL_PARAM_ERROR_MESSAGE);
        }
        validateBonusNumber(numbers, bonus);
        this.bonus = bonus;
    }

    private void validateBonusNumber(LottoNumbers numbers, LottoNumber bonus) {
        if (numbers.getValue().contains(bonus)) {
            throw new ValidLottoException("당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

//    public LottoNumber getBonus() {
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
