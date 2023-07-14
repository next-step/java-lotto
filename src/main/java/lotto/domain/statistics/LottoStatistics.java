package lotto.domain.statistics;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.game.Lotto;
import lotto.domain.game.Lottos;
import lotto.domain.game.Payment;
import lotto.domain.game.WinningNumber;

public final class LottoStatistics {

    private final Map<LottoMatch, Integer> statistics = new EnumMap<>(LottoMatch.class);
    private final double profitRate;

    public LottoStatistics(final Lottos lottos, final WinningNumber winningNumber,
        final Payment payment) {
        calculateStatistics(lottos, winningNumber);
        profitRate = calculateProfitRate(payment);
    }

    private void calculateStatistics(final Lottos lottos, final WinningNumber winningNumber) {
        lottos.getLottos().stream().map(lotto -> getLottoMatchKey(lotto, winningNumber))
            .forEach(this::putLotto);
        statistics.remove(LottoMatch.NONE_MATCH);
    }

    private LottoMatchKey getLottoMatchKey(final Lotto lotto, final WinningNumber winningNumber) {
        return new LottoMatchKey(lotto.hasLottoNumber(winningNumber.getBonusBall()),
            lotto.countMatch(winningNumber.getWinningLotto()));
    }

    private void putLotto(final LottoMatchKey lottoMatchKey) {
        statistics.put(LottoMatch.find(lottoMatchKey),
            statistics.getOrDefault(LottoMatch.find(lottoMatchKey), 0) + 1);
    }

    private double calculateProfitRate(final Payment payment) {
        double profit = 0;
        for (LottoMatch lottoMatch : statistics.keySet()) {
            profit += (double) statistics.get(lottoMatch) * lottoMatch.getPrize();
        }
        profit /= payment.getMoney();
        return Math.round(profit * 100) / 100.0;
    }

    public Map<LottoMatch, Integer> getStatistics() {
        return statistics;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
