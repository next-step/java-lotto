package lotto.factories;

import lotto.domain.LottoDiscriminator;
import lotto.domain.LottoNumber;

public class LottoDiscriminatorFactory {
    public static LottoDiscriminator from(String[] winningNumbers, String bonusNumber) {
        return new LottoDiscriminator(
                LottoTicketFactory.from(winningNumbers),
                LottoNumber.of(Integer.parseInt(bonusNumber))
        );
    }
}
