package lotto.domain;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.stream.IntStream;

public class LottoShop {

    private static final int PRICE_PER_LOTTO = 1000;
    private static final NumberGenerator numberGenerator = new LottoNumberGenerator();

    public Lottos purchase(PurchaseMoney purchaseMoney, List<LottoNumbers> manualLottoNumbers) {
        int lottoCount = getPossiblePurchaseLottoCount(purchaseMoney);
        int manualLottoCount = manualLottoNumbers.size();
        validateManualLottoPurchase(lottoCount, manualLottoCount);

        Lottos manualLottos = purchaseManualLotto(manualLottoNumbers);
        Lottos autoLottos = purchaseAutoLotto(lottoCount - manualLottoCount);
        return Lottos.combine(manualLottos, autoLottos);
    }

    private int getPossiblePurchaseLottoCount(PurchaseMoney purchaseMoney) {
        return purchaseMoney.getValue() / PRICE_PER_LOTTO;
    }

    private Lottos purchaseManualLotto(List<LottoNumbers> manualLottoNumbers) {
        return manualLottoNumbers.stream()
            .map(Lotto::new)
            .collect(collectingAndThen(toList(), Lottos::new));
    }

    private Lottos purchaseAutoLotto(int autoLottoCount) {
        return IntStream.range(0, autoLottoCount)
            .mapToObj(i -> Lotto.createFrom(numberGenerator))
            .collect(collectingAndThen(toList(), Lottos::new));
    }

    private void validateManualLottoPurchase(int lottoCount, int manualLottoCount) {
        if (lottoCount < manualLottoCount) {
            throw new IllegalArgumentException("수동 로또 구매 개수가 구매 가능한 수보다 많습니다.");
        }
    }
}
