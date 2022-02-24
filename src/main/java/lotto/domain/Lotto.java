package lotto.domain;

import static lotto.util.Constant.PRICE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<LottoTicket> lottoTickets;

    private final NumberGenerateStrategy numberGenerateStrategy;

    public Lotto(int userMoney, NumberGenerateStrategy numberGenerateStrategy) {
        int ticketNumber = buyLottoTickets(userMoney);
        this.numberGenerateStrategy = numberGenerateStrategy;
        this.lottoTickets = generateLottoTickets(ticketNumber);
    }

    private int buyLottoTickets(int money) {
        return money / PRICE;
    }

    public List<LottoTicket> generateLottoTickets(int number) {
        List<LottoTicket> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottoNumbers.add(generateTicket());
        }
        return lottoNumbers;
    }

    public LottoTicket generateTicket() {
        return new LottoTicket(numberGenerateStrategy.generateLottoNumber());
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
