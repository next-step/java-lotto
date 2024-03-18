package lotto.domain;

import lotto.dto.LottoResultDto;

import java.util.ArrayList;
import java.util.List;

import static lotto.util.ConstUtils.*;

public class PurchasedLotto {

    private final List<LottoNumbers> lottos;

    public PurchasedLotto(int purchasedMoney) {
        this.lottos = new ArrayList<>();

        int purchasedCount = calculatePurchasedCount(purchasedMoney);

        for (int i = 0; i < purchasedCount; i++) {
            this.lottos.add(new LottoNumbers());
        }
    }

    public PurchasedLotto(int purchasedMoney, List<LottoNumbers> manualLottoNumbers) {
        int purchasedCount = calculatePurchasedCount(purchasedMoney);

        validatePurchasedAndManualCount(purchasedCount, manualLottoNumbers);

        this.lottos = new ArrayList<>();

        for (int i = 0; i < purchasedCount; i++) {
            this.lottos.add(manualLottoNumbers.get(i));
        }
    }

    public int purchasedLottoSize() {
        return this.lottos.size();
    }

    public List<LottoNumbers> getPurchasedLottoList() {
        return List.copyOf(lottos);
    }

    public LottoResultDto matchWinningNumbers(LottoNumbers winningNumbers) {
        LottoMatchedCalculator lottoMatchedCalculator = new LottoMatchedCalculator();

        for (LottoNumbers lotto : this.lottos) {
            int result = lotto.countMatchedWinningNumbers(winningNumbers);
            saveMatched(lottoMatchedCalculator, result);
        }

        return new LottoResultDto(
                lottoMatchedCalculator.countMatchedThree(),
                lottoMatchedCalculator.countMatchedFour(),
                lottoMatchedCalculator.countMatchedFive(),
                lottoMatchedCalculator.countMatchedSix(),
                lottoMatchedCalculator.earnRate(purchasedLottoPrice())
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

    private void saveMatched(LottoMatchedCalculator lottoMatchedCalculator, int result) {
        if (result >= MINIMUM_LOTTO_EARN_MATCH_COUNT) {
            lottoMatchedCalculator.saveMatched(result);
        }
    }

    private int purchasedLottoPrice() {
        return this.lottos.size() * LOTTO_WON_UNIT;
    }
}
