package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class LottoResult {

    public static final int COUNT = 1;
    public static final int SCALE = 2;

    private Map<WinningPrize, Integer> lottoPrizeResult = new LinkedHashMap<>();

    private LottoResult() {
        Arrays.stream(WinningPrize.values())
                .forEach(winningPrize -> this.lottoPrizeResult.put(winningPrize, 0));
    }

    public static LottoResult getInstance() {
        return new LottoResult();
    }

    public BigDecimal calculatePrizeRate(LottoMoney lottoMoney) {
        double totalPrize = lottoPrizeResult.entrySet().stream()
                .mapToInt(result -> result.getKey().getPrize() * result.getValue())
                .sum();

        BigDecimal reward = BigDecimal.valueOf(totalPrize);
        BigDecimal amount = BigDecimal.valueOf(lottoMoney.getMoney());

        return reward.divide(amount, SCALE, RoundingMode.FLOOR);
    }

    public void analyzeLottoRank(Set<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        lottoTickets.stream()
                .map(lottoTicket -> countMatchNumber(lottoTicket, winningLotto))
                .forEach(winningPrize -> recordWinningResult(winningPrize));
    }

    private WinningPrize countMatchNumber(LottoTicket lottoTicket, WinningLotto winningLotto) {
        int matchCount = lottoTicket.countMatchNumbers(winningLotto.getWinningLottoTicket());
        WinningPrize winningPrize = WinningPrize.valueOf(matchCount, winningLotto.isBonusBall(lottoTicket));
        return winningPrize;
    }

    private void recordWinningResult(WinningPrize winningValue) {
        lottoPrizeResult.put(winningValue, lottoPrizeResult.get(winningValue) + COUNT);
    }

    public Map<WinningPrize, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoPrizeResult);
    }
}
