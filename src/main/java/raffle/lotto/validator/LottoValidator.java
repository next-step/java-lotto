package raffle.lotto.validator;

import raffle.lotto.Lotto;

import java.util.List;

public interface LottoValidator {
    public boolean validator(List<Lotto> lotto);
}
