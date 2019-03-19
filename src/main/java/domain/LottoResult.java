package domain;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int WINNING_NUM_3_BENEFIT = 5000;
    private static final int WINNING_NUM_4_BENEFIT = 50000;
    private static final int WINNING_NUM_5_BENEFIT = 1500000;
    private static final int WINNING_NUM_6_BENEFIT = 2000000000;

    private List<Lotto> lottos;
    private Map<LottoResultStatus, Integer> lottoResults;
    private BigDecimal benefitRate;

    public LottoResult(List<Lotto> lottos, int[] winningNumbers) {
        this.lottos = lottos;
        this.benefitRate = BigDecimal.valueOf(0);
        this.lottoResults = new HashMap<>();
        initMap();
        lottos.stream()
                .map(lotto -> lotto.getLottoResultStatus(winningNumbers))
                .forEach(this::updateLottoResult);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    private void initMap() {
        for (LottoResultStatus status : LottoResultStatus.values()) {
            lottoResults.put(status, 0);
        }
    }

    private void updateLottoResult(LottoResultStatus status) {
        lottoResults.put(status, lottoResults.get(status) + 1);
    }

    public Map<LottoResultStatus, Integer> getLottoResults() {
        return lottoResults;
    }

    public void calculateBenefit(Price price) {
        BigDecimal totalAmountByWinning = new BigDecimal(0);
        totalAmountByWinning = BigDecimal.valueOf((lottoResults.get(LottoResultStatus.WINNING_NUM_3)) * WINNING_NUM_3_BENEFIT);
        totalAmountByWinning = totalAmountByWinning.add(BigDecimal.valueOf(lottoResults.get(LottoResultStatus.WINNING_NUM_4) * WINNING_NUM_4_BENEFIT));
        totalAmountByWinning = totalAmountByWinning.add(BigDecimal.valueOf(lottoResults.get(LottoResultStatus.WINNING_NUM_5) * WINNING_NUM_5_BENEFIT));
        totalAmountByWinning = totalAmountByWinning.add(BigDecimal.valueOf(lottoResults.get(LottoResultStatus.WINNING_NUM_6) * WINNING_NUM_6_BENEFIT));

        benefitRate =  price.totalRateByWinning(totalAmountByWinning);
    }

    public BigDecimal getBenefitRate() {
        return benefitRate;
    }
}
