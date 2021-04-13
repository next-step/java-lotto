package step2;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final int theNumberOfLottoTickets;
    private final LottoNumberGenerator lottoNumberGenerator;
    private final List<LottoTicket> lottoCollection = new ArrayList<>();

    public LottoTickets(int theNumberOfLottoTickets, LottoNumberGenerator lottoNumberGenerator){
        this.theNumberOfLottoTickets = theNumberOfLottoTickets;
        this.lottoNumberGenerator = lottoNumberGenerator;
        generateLottoCollection();
    }

    private void generateLottoCollection(){
        for (int i = 0; i < theNumberOfLottoTickets; i++) {
            lottoCollection.add(new LottoTicket(lottoNumberGenerator));
        }
    }

    public List<LottoTicket> getLottoCollection(){
        return lottoCollection;
    }
}
