package domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private List<Lotto> lottos;
    private Map<LottoResultStatus, Integer> lottoResults;

    public LottoResult(List<Lotto> lottos, WinningLotto winningNumbers) {
        this.lottos = lottos;
        this.lottoResults = new HashMap<>();
        initMap();

        for (Lotto lotto : lottos) {
            updateLottoResult(winningNumbers.result(lotto));
        }
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

    public Integer getLottoResult(LottoResultStatus resultStatus) {
        if (lottoResults.get(resultStatus) == null) {
            return 0;
        }

        return lottoResults.get(resultStatus);
    }

    public BigDecimal calculateBenefit(Money money) {
        BigDecimal totalAmountByWinning = new BigDecimal(0);

        for(LottoResultStatus status : LottoResultStatus.values()){
            totalAmountByWinning = totalAmountByWinning.add(LottoResultStatus.getWinnersPriceByStatus(lottoResults.get(status), status));
        }
        return money.totalRateByWinning(totalAmountByWinning);
    }
}
