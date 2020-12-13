package lotto.domain;

import lotto.domain.numbers.LottoNumber;
import lotto.domain.numbers.LottoTickets;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private static final int INTI_COUNT = 0;

    private final LottoTickets lottoTickets;
    private final Map<MatchPrize, Integer> lottoResult;

    public LottoGame(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
        this.lottoResult = new HashMap<>();
        putInitMatchPrize();
    }

    public Map<MatchPrize, Integer> matchNumbers(List<LottoNumber> winningLottoNumbers) {
        lottoTickets.getLottoTickets().forEach(lottoTicket -> {
            int matchCount = lottoTicket.matchWinningLottoNumbers(winningLottoNumbers);
            lottoResult.put(MatchPrize.valueOf(matchCount), lottoResult.get(MatchPrize.valueOf(matchCount)) + 1);
        });
        return lottoResult;
    }

    private void putInitMatchPrize() {
        Arrays.stream(MatchPrize.values())
                .forEach(matchPrize -> lottoResult.put(matchPrize, INTI_COUNT));
    }
}
