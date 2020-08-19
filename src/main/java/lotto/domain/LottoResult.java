package lotto.domain;

import java.util.*;

public class LottoResult {

    private static final int RATE = 100;

    private Map<WinningPrize, Integer> lottoResult = new LinkedHashMap<>();

    public LottoResult() {
        Arrays.stream(WinningPrize.values())
                .forEach(winningPrize -> this.lottoResult.put(winningPrize, 0));
    }

    public int calculatePrizeRate(int money) {
        return this.lottoResult.entrySet().stream()
                .mapToInt(result -> result.getKey().getPrize() * result.getValue()).sum() * RATE / money ;
    }

    public void analyzeLottoRank(Set<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        lottoTickets.stream()
                .map(lottoTicket -> countMatchNumber(lottoTicket, winningLotto))
                .forEach(winningPrize -> recordWinningResult(winningPrize));
    }

    private WinningPrize countMatchNumber(LottoTicket lottoTicket, WinningLotto winningLotto) {
        int matchCount = lottoTicket.countMatchNumbers(winningLotto.getWinningLottoNumber());
        WinningPrize winningPrize = WinningPrize.valueOf(matchCount);
        return winningPrize;
    }

    private void recordWinningResult(WinningPrize winningValue) {
        lottoResult.put(winningValue, lottoResult.get(winningValue) + 1);
    }

    public Map<WinningPrize, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
