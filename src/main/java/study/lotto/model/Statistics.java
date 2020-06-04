package study.lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistics {
    private final Lottos lottos;

    private Map<LottoRank, Integer> statistics;

    public Statistics(Lottos lottos) {
        this.lottos = lottos;
    }

    private void validateBonusNumber(WinningLotto winningLotto, int bonusNumber) {
        if(winningLotto.contains(new LottoNumber(bonusNumber))) {
            throw new IllegalArgumentException("당첨 번호에 보너스볼 번호가 포함되면 안됩니다.");
        }
    }

    public void calculateStatistics(WinningLotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);

        statistics = lottos.countingByLottoRank(winningLotto, bonusNumber);
    }

    public BigDecimal calculateEarningRate(int totalPrice) {
        BigDecimal totalEarning = new BigDecimal(calculateTotalEarning());

        return totalEarning.divide(new BigDecimal(totalPrice), 10, RoundingMode.HALF_EVEN);
    }

    private int calculateTotalEarning() {
        return statistics.keySet()
                .stream()
                .map(lottoRank -> lottoRank.getPrize() * statistics.get(lottoRank))
                .mapToInt(Integer::intValue).sum();
    }

    public Map<LottoRank, Integer> getStatistics() {
        return statistics;
    }
}
