package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private final List<Lotto> lottoTickets = new ArrayList<>();

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void buy() {
        lottoTickets.add(lottoGenerator.autoGenerate());
    }
    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
