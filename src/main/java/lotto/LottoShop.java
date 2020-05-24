package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private final List<Lotto> lottoTickets = new ArrayList<>();

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public Lotto buy() {
        Lotto lotto = lottoGenerator.autoGenerate();
        lottoTickets.add(lotto);
        return lotto;
    }
    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
