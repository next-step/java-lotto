package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
    private static final int DECIMAL_PLACES = 2;

    private int money;
    private List<Lotto> lottos;

    private LottoWallet(int money, List<Lotto> lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public static LottoWallet create(int money) {
        return new LottoWallet(money, new ArrayList<>());
    }

    public static LottoWallet create(int money, List<Lotto> lottos) {
        return new LottoWallet(money, lottos);
    }

    public int numberOfBuy(int price) {
        return (money / price) - lottos.size();
    }

    public BigDecimal rateReturn(int reward) {
        BigDecimal amountMoney = BigDecimal.valueOf(money);
        BigDecimal rewardMoney = BigDecimal.valueOf(reward);

        return rewardMoney.divide(amountMoney, DECIMAL_PLACES, RoundingMode.DOWN);
    }

    public List<Lotto> getManualLottos() {
        return lottos;
    }
}
