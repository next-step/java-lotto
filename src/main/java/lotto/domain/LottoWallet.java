package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static lotto.utils.LottoCollectionUtils.convert;

public class LottoWallet {
    private List<Lotto> lottos;
    private Money money;

    private LottoWallet(Money money, List<Lotto> lottos) {
        this.money = money;
        this.lottos = lottos;
    }

    public static LottoWallet create(Money money) {
        return new LottoWallet(money, new ArrayList<>());
    }

    public static LottoWallet create(String inputMoney, String manualNumber) {
        Money money = Money.create(inputMoney);
        List<Lotto> lottos = new ArrayList<>();
        for (String number: manualNumber.split("\n")) {
            lottos.add(Lotto.create(convert(number.split(", ")), false));
        }
        return new LottoWallet(money, lottos);
    }

    public static LottoWallet create(Money money, List<Lotto> lottos) {
        return new LottoWallet(money, lottos);
    }

    public BigDecimal rateReturn(int reward) {
        return money.rateReturn(reward);
    }

    public int numberOfBuy(int price) {
        return money.numberOfBuy(price);
    }

    public List<Lotto> getManualLottos() {
        return lottos;
    }
}
