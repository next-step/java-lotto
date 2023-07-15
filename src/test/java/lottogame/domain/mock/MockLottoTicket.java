package lottogame.domain.mock;

import lottogame.domain.LottoTicket;
import lottogame.domain.spi.NumberGenerator;

import java.util.Set;

public class MockLottoTicket extends LottoTicket {

    public MockLottoTicket(NumberGenerator numberGenerator) {
        super(numberGenerator);
    }

    public MockLottoTicket(Set<Integer> values) {
        super(values);
    }
}
