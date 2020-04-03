package lotto.domain.item;

import lotto.domain.Money;
import lotto.domain.strategy.LottoNumberAutoGenerator;
import lotto.view.MatchedLottoDto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    public LottoGame() {
    }

    public LottoTickets createAutoLottoTicket(int count) {
        List<LottoTicket> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            LottoNumbers numbers = LottoNumbers.createLottoNumbersUseInteger(LottoNumberAutoGenerator.generateLottoNumber());
            lottos.add(new LottoTicket(numbers));
        }

        return new LottoTickets(lottos);
    }

    public LottoTickets createPassivityLottoTicket(List<LottoNumbers> numbers) {
        return LottoTickets.createLottoToPassivity(numbers);
    }

    public int getAvailableBuyCount(Money money) {
        return money.getHowManyBuyItem(new Money(LottoTicket.PRICE));
    }
}
