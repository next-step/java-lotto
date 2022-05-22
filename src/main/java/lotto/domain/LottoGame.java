package lotto.domain;

import lotto.domain.constant.Rank;
import lotto.dto.LottoPurchaseCountDto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;
    private static final String INVALID_BONUS_NUMBER = "로또 당첨 번호와 보너스 번호가 일치할 수 없습니다. 보너스 번호 : %d";

    private final PurchaseAmount purchaseAmount;
    private final PurchaseLottoCount purchaseLottoCount;
    private final Lottos lottos;

    public LottoGame(PurchaseAmount purchaseAmount, List<LottoNumbers> manualLottoNumbers) {
        this.purchaseLottoCount = new PurchaseLottoCount(purchaseAmount, manualLottoNumbers.size(), LOTTO_PRICE);
        this.purchaseAmount = purchaseAmount;
        this.lottos = new Lottos(purchaseLottoCount, manualLottoNumbers);
    }

    public LottoPurchaseCountDto getPurchaseCount() {
        return new LottoPurchaseCountDto(purchaseLottoCount.getAutoLottoCount(), purchaseLottoCount.getManualLottoCount());
    }

    public void confirmLottos(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        if (winningLottoNumbers.isContain(bonusNumber)) {
            throw new IllegalArgumentException(String.format(INVALID_BONUS_NUMBER, bonusNumber.getNumber()));
        }
        lottos.confirmAll(winningLottoNumbers, bonusNumber);
    }

    public List<LottoNumbers> getLottoNumbers() {
        return this.lottos.getLottoNumbers();
    }

    public int matchRankCount(Rank rank) {
        return lottos.countMatchRank(rank);
    }

    public double calculateBenefitRate() {
        return (double) lottos.getTotalPrizeMoney() / (double) purchaseAmount.getPurchaseAmount();
    }
}
