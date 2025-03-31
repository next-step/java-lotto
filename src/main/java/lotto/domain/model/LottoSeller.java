package lotto.domain.model;

import lotto.view.model.LottoInput;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {
    public static final int PRICE = 1000;

    public List<Lotto> sellManualLotto(LottoInput lottoInput) {
        int purchaseAmount = lottoInput.getPurchasedAmount();
        List<Lotto> manualLottos = lottoInput.getManualLottos();

        validatePurchaseAmount(purchaseAmount, manualLottos.size());

        return manualLottos;
    }

    public List<Lotto> sellAutoLotto(LottoInput lottoInput) {
        int totalCount = getPurchasableLottoCount(lottoInput.getPurchasedAmount());
        return generateLotto(totalCount - lottoInput.getManualLottos().size());
    }

    private static void validatePurchaseAmount(int purchaseAmount, int count) {
        if (getPurchasableLottoCount(purchaseAmount) < count) throw new IllegalArgumentException("구매 가능한 로또 장수를 초과했습니다.");
    }

    private static int getPurchasableLottoCount(int purchasedAmount) {
        return purchasedAmount / PRICE;
    }

    private List<Lotto> generateLotto(int count) {
        return Stream.generate(Lotto::createAuto)
                .limit(count)
                .collect(Collectors.toList());
    }
}
