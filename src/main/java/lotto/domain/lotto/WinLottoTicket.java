package lotto.domain.lotto;

import lotto.exception.ValidLottoException;

import java.util.List;
import java.util.Objects;

public class WinLottoTicket {

    private static final String NULL_PARAM_ERROR_MESSAGE = "매개변수:null";
    private static final String DUPLICATE_LOTTO_NUMBER = "당첨 번호와 보너스 번호가 중복됩니다";

    private final LottoTicket lottoTicket;
    private final LottoNumber bonus;

    public WinLottoTicket(final LottoNumbers numbers, final LottoNumber bonus) {
        validateNull(bonus);
        validateBonusNumber(numbers, bonus);
        this.lottoTicket = new LottoTicket(numbers);
        this.bonus = bonus;
    }

    public WinLottoTicket(final List<LottoNumber> numbers, final LottoNumber bonus) {
        validateNull(bonus);
        validateBonusNumber(numbers, bonus);
        this.lottoTicket = new LottoTicket(numbers);
        this.bonus = bonus;
    }

    private void validateBonusNumber(final LottoNumbers numbers, final LottoNumber bonus) {
        if (numbers.getValue().contains(bonus)) {
            throw new ValidLottoException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void validateBonusNumber(final List<LottoNumber> numbers, final LottoNumber bonus) {
        if (numbers.contains(bonus)) {
            throw new ValidLottoException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void validateNull(final LottoNumber bonus) {
        if (bonus == null) {
            throw new ValidLottoException(NULL_PARAM_ERROR_MESSAGE);
        }
    }

    public LottoNumber getBonus() {
        return bonus;
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinLottoTicket that = (WinLottoTicket) o;
        return Objects.equals(lottoTicket, that.lottoTicket) &&
                Objects.equals(bonus, that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicket, bonus);
    }
}
