package lotto.domain;

import static lotto.util.Constant.*;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import lotto.view.ResultView;

public class Lotto {

    private final List<LottoTicket> lottoTickets;

    public Lotto(int userMoney) {
        int ticketNumber = buyLottoTickets(userMoney);
        this.lottoTickets = generateLottoTickets(ticketNumber);
        ResultView.printLottoTicketsInfo(lottoTickets);
    }

    private int buyLottoTickets(int money) {
        return money / PRICE;
    }

    public List<LottoTicket> generateLottoTickets(int number) {
        List<LottoTicket> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottoNumbers.add(new LottoTicket(LottoNumberGenerator.generateRandomLottoNumber()));
        }
        return lottoNumbers;
    }

    public int getNumOfTickets() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
