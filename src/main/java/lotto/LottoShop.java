package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public LottoTicket buy() {
        LottoTicket lotto = lottoGenerator.autoGenerate();
        lottoTickets.add(lotto);
        return lotto;
    }
    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
