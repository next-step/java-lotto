package lotto.service;

import java.util.List;
import lotto.domain.LottoTickets;
import lotto.domain.Money;

public interface LottoTicketsGenerator {

    LottoTickets generate(Money money);

    LottoTickets generate(List<String> manualLottoNumbers);

}
