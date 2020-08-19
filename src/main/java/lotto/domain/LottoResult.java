package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LottoResult {

    private static final int RATE = 100;
    private Map<WinningPrize, Integer> lottoResult = new LinkedHashMap<>();

    public LottoResult() {
        Arrays.stream(WinningPrize.values())
                .forEach(winningValue -> this.lottoResult.put(winningValue, 0));
    }

    public int calculatePrizeRate(int money) {
        return this.lottoResult.entrySet().stream()
                .mapToInt(result -> result.getKey().getPrize() * result.getValue()).sum() / money * RATE;
    }

    public void analyzeLottoRank(Set<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        lottoTickets.stream()
                .map(lottoTicket -> countMatchNumber(lottoTicket, winningLotto))
                .forEach(this::recordWinningResult);
    }

    private WinningPrize countMatchNumber(LottoTicket lotto, WinningLotto winningLotto) {
        int matchCount = lotto.countMatchNumbers(winningLotto.getWinningLottoNumber());
        return WinningPrize.valueOf(matchCount);
    }

    private void recordWinningResult(WinningPrize winningValue) {
        lottoResult.put(winningValue, lottoResult.get(winningValue) + 1);
    }
}
