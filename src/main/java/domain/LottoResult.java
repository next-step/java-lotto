package domain;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

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

        for(LottoResultStatus status : LottoResultStatus.values()){
            totalAmountByWinning = totalAmountByWinning.add(LottoResultStatus.getWinnersPriceByStatus(lottoResults.get(status), status));
        }
        benefitRate =  price.totalRateByWinning(totalAmountByWinning);
    }

    public BigDecimal getBenefitRate() {
        return benefitRate;
    }
}
