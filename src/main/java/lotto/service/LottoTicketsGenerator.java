package lotto.service;

import java.util.List;
import lotto.domain.LottoTickets;
import lotto.domain.Money;

public interface LottoTicketsGenerator {

    default LottoTickets generate(Money money) {
        return null;
    }

    default LottoTickets generate(List<String> manualLottoNumbers) {
        return null;
    }

}
