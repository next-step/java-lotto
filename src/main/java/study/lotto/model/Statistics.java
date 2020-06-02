package study.lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final Lottos lottos;
    private final Map<LottoRank, Integer> statistics = new HashMap<>();

    public Statistics(Lottos lottos) {
        this.lottos = lottos;

        for(LottoRank lottoRank : LottoRank.values()) {
            statistics.put(lottoRank, 0);
        }
    }

    private void validateBonusNumber(WinningLotto winningLotto, int bonusNumber) {
        if(winningLotto.getLottoNumbers().contains(new LottoNumber(bonusNumber))) {
            throw new IllegalArgumentException("당첨 번호에 보너스볼 번호가 포함되면 안됩니다.");
        }
    }

    public void calculateStatistics(WinningLotto winningLotto, int bonusNumber) {
        validateBonusNumber(winningLotto, bonusNumber);

        lottos.getLottoList()
                .forEach(lotto -> {
                    LottoRank lottoRank = lotto.getLottoRank(winningLotto, bonusNumber);
                    statistics.put(lottoRank, statistics.get(lottoRank)+1);
                });
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
