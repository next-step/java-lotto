package lottogame.domain;

import lottogame.domain.spi.NumberGenerator;

public class AutoLottoTicket extends LottoTicket{

    public AutoLottoTicket(NumberGenerator numberGenerator) {
        super(numberGenerator);
    }
}
