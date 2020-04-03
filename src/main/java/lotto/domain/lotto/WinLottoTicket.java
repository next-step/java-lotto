package lotto.domain.lotto;

import lotto.exception.ValidLottoException;

import java.util.List;
import java.util.Objects;

public class WinLottoTicket extends Lotto {

    private static final String NULL_PARAM_ERROR_MESSAGE = "매개변수:null";
    private static final String DUPLICATE_LOTTO_NUMBER = "당첨 번호와 보너스 번호가 중복됩니다";

    private final LottoNumber bonus;

    public WinLottoTicket(LottoNumbers numbers, LottoNumber bonus) {
        super(numbers);
        if (bonus == null) {
            throw new ValidLottoException(NULL_PARAM_ERROR_MESSAGE);
        }
        validateBonusNumber(numbers, bonus);
        this.bonus = bonus;
    }

    public WinLottoTicket(List<LottoNumber> numbers, LottoNumber bonus) {
        super(numbers);
        if (bonus == null) {
            throw new ValidLottoException(NULL_PARAM_ERROR_MESSAGE);
        }
        validateBonusNumber(numbers, bonus);
        this.bonus = bonus;
    }

    private void validateBonusNumber(LottoNumbers numbers, LottoNumber bonus) {
        if (numbers.getValue().contains(bonus)) {
            throw new ValidLottoException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void validateBonusNumber(List<LottoNumber> numbers, LottoNumber bonus) {
        if (numbers.contains(bonus)) {
            throw new ValidLottoException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    public LottoNumber getBonus() {
        return bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WinLottoTicket that = (WinLottoTicket) o;
        return Objects.equals(bonus, that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }
}
