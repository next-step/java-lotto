package lotto.domain;

import lotto.data.LottoBall;
import lotto.data.LottoWinInfo;
import lotto.dto.LottoResultDto;

import java.util.*;

import static lotto.util.ConstUtils.*;

public class PurchasedLotto {

    private final List<Lotto> lottoBundle;

    public PurchasedLotto(int purchasedMoney) {
        this.lottoBundle = new ArrayList<>();

        int purchaseCount = calculatePurchasedCount(purchasedMoney);

        for (int i = 0; i < purchaseCount; i++) {
            this.lottoBundle.add(new Lotto());
        }
    }

    public PurchasedLotto(int purchasedMoney, List<Lotto> manualLottoNumbers) {
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

    public List<Lotto> getPurchasedLottoList() {
        return List.copyOf(lottoBundle);
    }

    public LottoResultDto matchWinningNumbers(Lotto winningLottoNumbers, LottoBall bonusNumber) {
        Map<LottoWinInfo, Integer> lottoResultMap = initializeLottoResultMap();

        for (Lotto lotto : this.lottoBundle) {
            WinLottoBalls winLottoBalls = new WinLottoBalls(winningLottoNumbers, bonusNumber);

            lottoResultMap.computeIfPresent(
                    winLottoBalls.countMatchWithBonus(lotto),
                    (key, value) -> value + 1
            );
        }

        return LottoResultDto.of(lottoResultMap, earnRate(lottoResultMap));
    }

    private static int calculatePurchasedCount(int purchasedMoney) {
        return purchasedMoney / LOTTO_WON_UNIT;
    }

    private void validatePurchasedAndManualCount(int purchasedCount, List<Lotto> manualLottoNumbers) {
        if (purchasedCount != manualLottoNumbers.size()) {
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
        return this.lottoBundle.size() * LOTTO_WON_UNIT;
    }
}
