package lotto.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class LottoResult {
    private static final int SING_OF_DECIMAL_TWO = 2;
    private static final int PRICE_PER_PIECE = 1000;

    private final List<WinningType> winningTypes;
    private final LottoBundle lottoBundle;

    public LottoResult(List<WinningType> winningTypes, LottoBundle lottoBundle) {
        this.winningTypes = Collections.unmodifiableList(winningTypes);
        this.lottoBundle = lottoBundle;
    }

    public List<WinningType> getWinningTypes() {
        return winningTypes;
    }

    public long countByWinningtype(WinningType type) {
        return winningTypes.stream()
                .filter(winningType -> winningType.equals(type))
                .count();
    }

    public BigDecimal calculateEarningRate() {
        BigDecimal amount = BigDecimal.ZERO;
        for (WinningType winningType : winningTypes) {
            amount = amount.add(winningType.getWinningAmount());
        }
        return amount.divide(BigDecimal.valueOf(lottoBundle.size() * PRICE_PER_PIECE), SING_OF_DECIMAL_TWO, BigDecimal.ROUND_CEILING);
    }
}
