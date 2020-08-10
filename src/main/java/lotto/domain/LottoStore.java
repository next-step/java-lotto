package lotto.domain;

import java.util.List;
import java.util.Set;

import lotto.domain.core.Lotto;
import lotto.domain.core.WinLotto;
import lotto.ui.view.DisplayLottoList;
import lotto.ui.view.DisplayLottoStatistics;

import static java.util.stream.Collectors.toList;

public class LottoStore {
    public static final String ERROR_MESSAGE_CHECK_PURCHASE_AMOUNT = "로또 구매금액은 0보다 커야 합니다.";
    private static final int ZERO = 0;
    private final LottoPurchase lottoPurchase;
    private final ImmutableLottoList lottos;

    private static void verifyPurchaseAmount(int purchaseAmount) {
        if (ZERO >= purchaseAmount) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CHECK_PURCHASE_AMOUNT);
        }
    }

    LottoStore(int purchaseAmount) {
        verifyPurchaseAmount(purchaseAmount);
        lottoPurchase = LottoPurchase.buyAllAuto(purchaseAmount);
        lottos = ImmutableLottoList.builder()
                                   .autoLottos(lottoPurchase.getAutoLottoGeneratedCount())
                                   .build()
        ;
    }

    LottoStore(int purchaseAmount, ImmutableLottoList lottos) {
        verifyPurchaseAmount(purchaseAmount);
        this.lottoPurchase = LottoPurchase.buyAllAuto(purchaseAmount);
        this.lottos = lottos;
    }

    public static LottoStore purchaseAutoLotto(int purchaseAmount) {
        return new LottoStore(purchaseAmount);
    }

    public int countOfPurchased() {
        return lottos.size();
    }

    public LottoStatistics getStatistics(WinLotto winLotto){
        List<LottoWinningAndPrizeMoney> allMatchCount = lottos.compareToEachLottoWithWonLotto(winLotto);
        return LottoStatistics.fromAllMatchCount(lottoPurchase, allMatchCount);
    }

    public DisplayLottoList displayLottoList(){
        List<Set<Integer>> lottoList = lottos.stream()
                                           .map(Lotto::getPrimitiveLottoNos)
                                           .collect(toList());

        return new DisplayLottoList(lottoList);
    }

    public DisplayLottoStatistics displayLottoStatistics(WinLotto winLotto){
        return new DisplayLottoStatistics(getStatistics(winLotto));
    }
}
