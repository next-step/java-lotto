package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private final List<Lotto> lottoTickets = new ArrayList<>();

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public List<Lotto> buy() {
        lottoTickets.add(lottoGenerator.autoGenerate());
        return lottoTickets;
    }
}
