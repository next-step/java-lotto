package lotto.domain;

import lotto.dto.LottoResultDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchasedLotto {

    private final List<LottoNumbers> lottos = new ArrayList<>();

    public PurchasedLotto(int purchasedCount) {
        for (int i = 0; i < purchasedCount; i++) {
            lottos.add(new LottoNumbers());
        }
    }

    public PurchasedLotto(int purchasedCount, List<LottoNumbers> manualLottoNumbers) {
        if (purchasedCount != manualLottoNumbers.size()) {
            throw new IllegalArgumentException("구매 개수와 수동 개수가 일치하지 않습니다.");
        }

        for (int i = 0; i < purchasedCount; i++) {
            this.lottos.add(manualLottoNumbers.get(i));
        }
    }

    public int myLottoSize() {
        return this.lottos.size();
    }

    public LottoResultDto matchWinningNumbers(LottoNumbers winningNumbers) {
        Map<Integer, Integer> matchedCount = new HashMap<>();
        matchedCount.put(3, 0);
        matchedCount.put(4, 0);
        matchedCount.put(5, 0);
        matchedCount.put(6, 0);
        double earnRate = 0L;

        for (LottoNumbers lotto : this.lottos) {
            int result = lotto.countMatchedWinningNumbers(winningNumbers);
            winningNumbers.scanReset();
            matchedCount.put(result, matchedCount.get(result) + 1);
        }

        int sum = matchedCount.get(3) * 5000 +
                matchedCount.get(4) * 50000 +
                matchedCount.get(5) * 1500000 +
                matchedCount.get(6) * 2000000000;
        earnRate = (double) sum / (this.lottos.size() * 1000);

        return new LottoResultDto(
                matchedCount.get(3),
                matchedCount.get(4),
                matchedCount.get(5),
                matchedCount.get(6),
                earnRate
        );
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        lottos.forEach(lotto -> stringBuffer.append(lotto.toString()).append("\n"));
        return stringBuffer.toString();
    }
}
