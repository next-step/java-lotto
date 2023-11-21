package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public static final int LOTTO_PRICE = 1000;
    private static final LottoNumberFactory lottoNumberFactory = LottoNumberFactory.getInstance();

    public static LottoWallet buy(MoneyWallet moneyWallet) {
        List<Lotto> lottos = new ArrayList<>();
        int count = countOfLottoAvailablePurchase(moneyWallet.balance());
        for (int i = 0; i < count; i++) {
            lottos.add(createLottoTicket());
        }
        return LottoWallet.of(lottos, totalPurchaseAmount(count));
    }

    private static int totalPurchaseAmount(int count) {
        return count * LOTTO_PRICE;
    }

    private static int countOfLottoAvailablePurchase(int balance) {
        return balance / LOTTO_PRICE;
    }

    private static Lotto createLottoTicket() {
        return Lotto.from(lottoNumberFactory.number());
    }

}
