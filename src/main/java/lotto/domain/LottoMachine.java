package lotto.domain;

import java.util.List;

/**
 * 요청한 돈만큼 랜덤한 로또들을 만들어주는 객체
 */
public final class LottoMachine {
    public static final String INVALID_LOTTO_PRICE_MESSAGE = "로또를 구매하려면 최소 1000원 이상을 입력해야합니다.";
    private final Money lottoPrice;

    public LottoMachine(final Money lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public List<Lotto> pullSlot(final PurchaseInformation purchaseInformation, final LottoNumberGenerator lottoNumberGenerator) {
        return lottoNumberGenerator.drawLots(purchaseInformation.getLottoCount());
    }

    private void validateMoney(final Money toPurchaseMoney) {
        if (toPurchaseMoney.compareTo(lottoPrice) < 0) {
            throw new IllegalArgumentException(INVALID_LOTTO_PRICE_MESSAGE);
        }
    }

    public int getPurchableLottoCount(final Money money) {
        validateMoney(money);
        return money.getMoney() / lottoPrice.getMoney();
    }
}
