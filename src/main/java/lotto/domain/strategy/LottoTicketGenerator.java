package lotto.domain.strategy;

import lotto.domain.item.LottoNumbers;
import lotto.domain.item.LottoTicket;
import lotto.domain.item.LottoTickets;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {

    public LottoTicketGenerator() {
    }

    public LottoTickets generate(int count) {
        List<LottoTicket> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            LottoNumbers numbers = LottoNumbers.createLottoNumbersUseInteger(LottoNumberAutoGenerator.generateLottoNumber());
            result.add(new LottoTicket(numbers));
        }
        return new LottoTickets(result);
    }
}
