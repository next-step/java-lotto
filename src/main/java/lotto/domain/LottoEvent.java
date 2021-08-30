package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoEvent {
    private PurchaseAmount purchaseAmount;
    private PurchaseLottos purchaseLottos;
    private Lotto winningNumber;
    private LottoResults lottoResults;

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = new PurchaseAmount(purchaseAmount);
        purchaseLottos = new PurchaseLottos(this.purchaseAmount.getLottoCount());
    }

    public void setWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = new Lotto(winningNumber);
    }

    public void setLottoResults() {
        List<Integer> sameNumberCounts = purchaseLottos.getPurchaseLottoList()
                .stream()
                .mapToInt(lotto -> lotto.sameLottoNumberCount(winningNumber))
                .boxed()
                .collect(Collectors.toList());

        lottoResults = new LottoResults(sameNumberCounts);
    }

    public List<Lotto> getPurchaseLottoList() {
        return purchaseLottos.getPurchaseLottoList();
    }

    public LottoResults getLottoResults() {
        return lottoResults;
    }
}
