package lotto.factories;

import lotto.domain.LottoDiscriminator;

public class LottoDiscriminatorFactory {
    public static LottoDiscriminator from(String[] winningNumbers) {
        return new LottoDiscriminator(LottoTicketFactory.from(winningNumbers));
    }
}
