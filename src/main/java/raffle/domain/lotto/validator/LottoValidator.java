package raffle.domain.lotto.validator;

import raffle.domain.lotto.Lotto;

import java.util.List;

public interface LottoValidator {
    public boolean validator(List<Lotto> lotto);
}
