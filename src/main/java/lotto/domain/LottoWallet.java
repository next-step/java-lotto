package lotto.domain;

import lotto.utils.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWallet {

    private int countOfLottoTicket;
    private List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoWallet(int countOfLottoTicket) {
        this.countOfLottoTicket = countOfLottoTicket;
    }

    public void buyLotto() {
        for (int i = 0; i < countOfLottoTicket; i++) {
            List<LottoNumber> lottoNumbers = LottoNumberGenerator.autoGenerator();
            LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);

            lottoTickets.add(lottoTicket);
        }
    }

    public int ticketCount() {
        return countOfLottoTicket;
    }

    public List<LottoTicket> lottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
