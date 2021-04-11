package step2.domain;

import step2.utils.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final int numberOfLottoTickets;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoTickets(int numberOfLottoTickets, LottoNumberGenerator lottoNumberGenerator){
        this.numberOfLottoTickets = numberOfLottoTickets;
        this.lottoNumberGenerator = lottoNumberGenerator;
        buyLottoTickets();
    }

    private void buyLottoTickets(){
        for (int i = 0; i < numberOfLottoTickets; i++) {
            lottoTickets.add(new LottoTicket(lottoNumberGenerator));
        }
    }

    public List<LottoTicket> getLottoTickets(){
        return lottoTickets;
    }

    public int getNumberOfLottoTickets(){
        return numberOfLottoTickets;
    }
}
