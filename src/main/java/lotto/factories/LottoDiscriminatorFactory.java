package lotto.factories;

import lotto.domain.LottoDiscriminator;

public class LottoDiscriminatorFactory {
    public static LottoDiscriminator from(String[] winningNumbers, String bonusNumber) {
        return new LottoDiscriminator(LottoTicketFactory.from(winningNumbers, bonusNumber));
    }
}
