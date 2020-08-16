package lotto.domain;

import java.util.List;

import lotto.domain.core.WinningLotto;
import lotto.ui.view.DisplayLottoList;
import lotto.ui.view.DisplayLottoStatistics;

public final class LottoStore {
    private final LottoPurchase lottoPurchase;
    private final ImmutableLotteries lottos;

    LottoStore(int purchaseAmount) {
        lottoPurchase = LottoPurchase.buyAllAuto(purchaseAmount);
        lottos = ImmutableLotteries.builder()
                                   .autoLottos(lottoPurchase.getAutoLottoGeneratedCount())
                                   .build()
        ;
    }

    LottoStore(int purchaseAmount, ImmutableLotteries lottos) {
        this.lottoPurchase = LottoPurchase.buyAllAuto(purchaseAmount);
        this.lottos = lottos;
    }

    LottoStore(LottoPurchase lottoPurchase, ImmutableLotteries lottos){
        this.lottoPurchase = lottoPurchase;
        this.lottos = lottos;
    }

    public static LottoStore purchaseAutoLotto(int purchaseAmount) {
        return new LottoStore(purchaseAmount);
    }

    public static LottoManualSalesStoreBuilder purchaseManualOrAutoLotto(int purchaseAmount, int manualLottoCount) {
        final LottoPurchase lottoPurchase = LottoPurchase.buyAutoOrManual(purchaseAmount, manualLottoCount);
        return LottoManualSalesStoreBuilder.createManualLottos(lottoPurchase);
    }

    public int countOfPurchased() {
        return lottos.size();
    }

    public LottoStatistics getStatistics(WinningLotto winningLotto){
        List<LottoWinningAndPrizeMoney> allMatchCount = lottos.compareToEachLottoWithWonLotto(winningLotto);
        return LottoStatistics.fromAllMatchCount(lottoPurchase, allMatchCount);
    }

    public DisplayLottoList displayLottoList(){
        return new DisplayLottoList(lottos);
    }

    public DisplayLottoStatistics displayLottoStatistics(WinningLotto winningLotto){
        return new DisplayLottoStatistics(getStatistics(winningLotto));
    }
}
