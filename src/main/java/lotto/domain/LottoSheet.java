package lotto.domain;

import lotto.data.LottoWinInfo;
import lotto.dto.LottoResultDto;

import java.util.*;

import static lotto.util.ConstUtils.*;

public class LottoSheet {

    private final List<Lotto> lottoSheet;

    public LottoSheet(int purchasedPrice) {
        int purchaseCount = calculatePurchasedCount(purchasedPrice);

        this.lottoSheet = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            this.lottoSheet.add(new Lotto());
        }
    }

    public LottoSheet(int purchasedPrice, List<Lotto> manualLottoNumbers) {
        int purchasedCount = calculatePurchasedCount(purchasedPrice);

        validatePurchasedAndManualCount(purchasedCount, manualLottoNumbers.size());

        this.lottoSheet = new ArrayList<>();
        for (int i = 0; i < purchasedCount; i++) {
            this.lottoSheet.add(manualLottoNumbers.get(i));
        }
    }

    public int purchasedCount() {
        return this.lottoSheet.size();
    }

    public List<Lotto> getPurchasedLottoList() {
        return List.copyOf(lottoSheet);
    }

    public LottoResultDto matchWin(WinLottoBalls winLottoBalls) {
        Map<LottoWinInfo, Integer> lottoResultMap = initializeLottoResultMap();

        for (Lotto lotto : this.lottoSheet) {
            lottoResultMap.computeIfPresent(
                    winLottoBalls.countMatchWithBonus(lotto),
                    (key, value) -> value + 1
            );
        }

        return LottoResultDto.of(lottoResultMap, earnRate(lottoResultMap));
    }

    private static int calculatePurchasedCount(int purchasedPrice) {
        return purchasedPrice / LOTTO_WON_UNIT;
    }

    private void validatePurchasedAndManualCount(int purchasedCount, int manualLottoCount) {
        if (purchasedCount != manualLottoCount) {
            throw new IllegalArgumentException("구매 개수와 수동 개수가 일치하지 않습니다.");
        }
    }

    private Map<LottoWinInfo, Integer> initializeLottoResultMap() {
        HashMap<LottoWinInfo, Integer> lottoResultMap = new HashMap<>();

        Arrays.stream(LottoWinInfo.values())
                .forEach(lottoWinInfo -> lottoResultMap.put(lottoWinInfo, 0));

        return lottoResultMap;
    }

    private double earnRate(Map<LottoWinInfo, Integer> lottoResultMap) {
        double winMoney = lottoResultMap.entrySet().stream()
                .mapToInt(entry -> entry.getValue() * entry.getKey().getWinningPrice())
                .sum();

        return winMoney / purchasedLottoPrice();
    }

    private int purchasedLottoPrice() {
        return this.lottoSheet.size() * LOTTO_WON_UNIT;
    }
}
