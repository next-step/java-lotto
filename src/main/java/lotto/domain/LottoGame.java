package lotto.domain;

import java.util.List;

public class LottoGame {

    private static final int ONE_GAME_PRICE = 1000;
    private final LottoTicket lottoTicket;

    public LottoGame(final int price, final LottoNumberSelectPolicy lottoNumberSelectPolicy) {
        this.lottoTicket = new LottoTicket(price / ONE_GAME_PRICE, lottoNumberSelectPolicy);
    }

    public int size() {
        return lottoTicket.size();
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    public List<LottoRank> checkResult(final WinningNumbers winningNumbers) {
        return lottoTicket.getLottoRanks(winningNumbers);
    }

}
