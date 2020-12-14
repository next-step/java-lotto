package lotto.domain;

import lotto.domain.numbers.LottoTickets;
import lotto.domain.numbers.WinningLottoNumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoGame {
    private static final int INIT_COUNT = 0;

    private final LottoTickets lottoTickets;
    private final Map<Rank, Integer> lottoResult;

    public LottoGame(final LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
        this.lottoResult = new HashMap<>();
        putInitMatchPrize();
    }

    public Map<Rank, Integer> matchNumbers(final WinningLottoNumbers winningLottoNumbers) {
        lottoTickets.getLottoTickets().forEach(lottoTicket -> {
            Rank rank = Rank.valueOf(lottoTicket.matchWinningLottoNumbers(winningLottoNumbers));
            lottoResult.put(rank, lottoResult.get(rank) + 1);
        });
        return lottoResult;
    }

    private void putInitMatchPrize() {
        Arrays.stream(Rank.values())
                .forEach(matchPrize -> lottoResult.put(matchPrize, INIT_COUNT));
    }
}
