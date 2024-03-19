package lotto.domain;

import lotto.data.LottoWinInfo;
import lotto.dto.LottoResultDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.util.ConstUtils.*;

public class PurchasedLotto {

    private final List<LottoNumbers> lottoBundle;

    public PurchasedLotto(int purchasedMoney) {
        this.lottoBundle = new ArrayList<>();

        int purchaseCount = calculatePurchasedCount(purchasedMoney);

        for (int i = 0; i < purchaseCount; i++) {
            this.lottoBundle.add(new LottoNumbers());
        }
    }

    public PurchasedLotto(int purchasedMoney, List<LottoNumbers> manualLottoNumbers) {
        int purchasedCount = calculatePurchasedCount(purchasedMoney);

        validatePurchasedAndManualCount(purchasedCount, manualLottoNumbers);

        this.lottoBundle = new ArrayList<>();

        for (int i = 0; i < purchasedCount; i++) {
            this.lottoBundle.add(manualLottoNumbers.get(i));
        }
    }

    public int purchasedCount() {
        return this.lottoBundle.size();
    }

    public List<LottoNumbers> getPurchasedLottoList() {
        return List.copyOf(lottoBundle);
    }

    public LottoResultDto matchWinningNumbers(LottoNumbers winningLottoNumbers) {
        Map<LottoWinInfo, Integer> lottoResultMap = initializeLottoResultMap();

        for (LottoNumbers lotto : this.lottoBundle) {
            lottoResultMap.computeIfPresent(
                    lotto.countMatchWithWinningLottoNumbers(winningLottoNumbers),
                    (key, value) -> value + 1
            );
        }

        return new LottoResultDto(
                lottoResultMap.get(LottoWinInfo.WIN_FOURTH),
                lottoResultMap.get(LottoWinInfo.WIN_THIRD),
                lottoResultMap.get(LottoWinInfo.WIN_SECOND),
                lottoResultMap.get(LottoWinInfo.WIN_FIRST),
                earnRate(lottoResultMap)
        );
    }

    private static int calculatePurchasedCount(int purchasedMoney) {
        return purchasedMoney / LOTTO_WON_UNIT;
    }

    private void validatePurchasedAndManualCount(int purchasedCount, List<LottoNumbers> manualLottoNumbers) {
        if (purchasedCount != manualLottoNumbers.size()) {
            throw new IllegalArgumentException("구매 개수와 수동 개수가 일치하지 않습니다.");
        }
    }

    private Map<LottoWinInfo, Integer> initializeLottoResultMap() {
        HashMap<LottoWinInfo, Integer> lottoResultMap = new HashMap<>();

        lottoResultMap.put(LottoWinInfo.WIN_FIRST, 0);
        lottoResultMap.put(LottoWinInfo.WIN_SECOND, 0);
        lottoResultMap.put(LottoWinInfo.WIN_THIRD, 0);
        lottoResultMap.put(LottoWinInfo.WIN_FOURTH, 0);
        lottoResultMap.put(LottoWinInfo.PASS, 0);

        return lottoResultMap;
    }

    private double earnRate(Map<LottoWinInfo, Integer> lottoResultMap) {
        double winMoney =
                lottoResultMap.get(LottoWinInfo.WIN_FOURTH) * LottoWinInfo.WIN_FOURTH.getWinningPrice() +
                lottoResultMap.get(LottoWinInfo.WIN_THIRD) * LottoWinInfo.WIN_THIRD.getWinningPrice() +
                lottoResultMap.get(LottoWinInfo.WIN_SECOND) * LottoWinInfo.WIN_SECOND.getWinningPrice() +
                lottoResultMap.get(LottoWinInfo.WIN_FIRST) * LottoWinInfo.WIN_FIRST.getWinningPrice();

        return winMoney / purchasedLottoPrice();
    }

    private int purchasedLottoPrice() {
        return this.lottoBundle.size() * LOTTO_WON_UNIT;
    }
}
