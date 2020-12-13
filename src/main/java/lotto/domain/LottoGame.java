package lotto.domain;

import lotto.domain.numbers.LottoNumber;
import lotto.domain.numbers.LottoTickets;
import lotto.domain.numbers.WinningLottoNumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private static final int INIT_COUNT = 0;

    private final LottoTickets lottoTickets;
    private final Map<MatchPrize, Integer> lottoResult;

    public LottoGame(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
        this.lottoResult = new HashMap<>();
        putInitMatchPrize();
    }

    public Map<MatchPrize, Integer> matchNumbers(WinningLottoNumbers winningLottoNumbers) {
        lottoTickets.getLottoTickets().forEach(lottoTicket -> {
            MatchPrize matchPrize = MatchPrize.valueOf(lottoTicket.matchWinningLottoNumbers(winningLottoNumbers));
            lottoResult.put(matchPrize, lottoResult.get(matchPrize) + 1);
        });
        return lottoResult;
    }

    private void putInitMatchPrize() {
        Arrays.stream(MatchPrize.values())
                .forEach(matchPrize -> lottoResult.put(matchPrize, INIT_COUNT));
    }
}
