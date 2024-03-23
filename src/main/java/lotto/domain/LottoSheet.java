package lotto.domain;

import lotto.data.LottoWinInfo;
import lotto.dto.LottoResultDto;

import java.util.*;

import static lotto.util.ConstUtils.*;

public class LottoSheet {

    private final List<Lotto> lottoSheet;
    private final int manualCount;

    public LottoSheet(int purchasedPrice) {
        int purchaseCount = calculatePurchasedCount(purchasedPrice);
        this.manualCount = 0;

        this.lottoSheet = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            this.lottoSheet.add(new Lotto());
        }
    }

    public LottoSheet(int purchasedPrice, List<Lotto> manualLottoNumbers) {
        int purchasedCount = calculatePurchasedCount(purchasedPrice);
        this.manualCount = manualLottoNumbers.size();

        validatePurchasedAndManualCount(purchasedCount, manualLottoNumbers.size());

        this.lottoSheet = new ArrayList<>();
        for (int i = 0; i < this.manualCount; i++) {
            this.lottoSheet.add(manualLottoNumbers.get(i));
        }
        for (int i = this.manualCount; i < purchasedCount; i++) {
            this.lottoSheet.add(new Lotto());
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

    public int countAuto() {
        return purchasedCount() - this.manualCount;
    }

    public int countManual() {
        return this.manualCount;
    }

    private static int calculatePurchasedCount(int purchasedPrice) {
        return purchasedPrice / LOTTO_WON_UNIT;
    }

    private void validatePurchasedAndManualCount(int purchasedCount, int manualLottoCount) {
        if (purchasedCount < manualLottoCount) {
            throw new IllegalArgumentException("수동 구매 리스트의 개수가 총 구매 개수보다 클 수 없습니다.");
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
