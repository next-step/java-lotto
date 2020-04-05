package lotto.domain.lotto;

import java.util.List;

public class LottoGame {

    public LottoGame() {
    }

    public LottoTickets createPassivityLottoTicket(List<LottoNumbers> numbers) {
        return LottoTickets.createLottoToPassivity(numbers);
    }
}
