package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {

    private NumberGeneratorStrategy numberGeneratorStrategy;

    public LottoSeller(NumberGeneratorStrategy numberGeneratorStrategy) {
        this.numberGeneratorStrategy = numberGeneratorStrategy;
    }

    public LottoWallet sell(List<LottoTicket> guestLottoNumber, PurchaseBudget purchaseBudget) {
        int countOfAutoLottoTicket = purchaseBudget.getAutoTicketCount();
        List<LottoTicket> lottoTickets = new ArrayList<>(guestLottoNumber);

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        for(int i = 0; i < countOfAutoLottoTicket; i++) {
            List<LottoNumber> lottoNumbers = lottoNumberGenerator.generator(numberGeneratorStrategy.generator());
            LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }

        return LottoWallet.create(lottoTickets, purchaseBudget);
    }
}
