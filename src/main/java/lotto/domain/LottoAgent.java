package lotto.domain;

import lotto.dto.PurchasedLottosDTO;

public class LottoAgent {
    private final PurchasedLottos purchasedLottos;

    private LottoAgent() {
        purchasedLottos = PurchasedLottos.newInstance();
    }

    public static LottoAgent newInstance() {
        return new LottoAgent();
    }

    public void buy(int price, LottoNumberSelectionStrategy selectionStrategy) {
        int buyingCount = price / Lotto.LOTTO_PRICE;
        for (int i = 0; i < buyingCount; i++) {
            buyLotto(i, selectionStrategy);
        }
    }

    private void buyLotto(int lottoNum, LottoNumberSelectionStrategy selectionStrategy) {
        purchasedLottos.addLotto(Lotto.newInstance(lottoNum, selectionStrategy));
    }

    public PurchasedLottosDTO getPurchasedLottos() {
        return PurchasedLottosDTO.valueOf(purchasedLottos);
    }
}
