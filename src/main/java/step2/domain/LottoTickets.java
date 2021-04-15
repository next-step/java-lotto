package step2.domain;

import step2.LottoNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final int theNumberOfLottoTickets;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoTickets(int theNumberOfLottoTickets, LottoNumberGenerator lottoNumberGenerator){
        this.theNumberOfLottoTickets = theNumberOfLottoTickets;
        this.lottoNumberGenerator = lottoNumberGenerator;
        generateLottoCollection();
    }

    private void generateLottoCollection(){
        for (int i = 0; i < theNumberOfLottoTickets; i++) {
            lottoTickets.add(new LottoTicket(lottoNumberGenerator));
        }
    }

    public List<LottoTicket> getLottoTickets(){
        return lottoTickets;
    }

    public int getTheNumberOfLottoTickets() {
        return theNumberOfLottoTickets;
    }
}
