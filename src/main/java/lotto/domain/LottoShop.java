package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoShop {
    private MoneyWallet moneyWallet;
    private final LottoShopFactory lottoShopFactory;

    private LottoShop(MoneyWallet moneyWallet, LottoShopFactory lottoShopFactory) {
        this.moneyWallet = moneyWallet;
        this.lottoShopFactory = lottoShopFactory;
    }

    public static LottoShop from(MoneyWallet moneyWallet, LottoShopFactory lottoShopFactory) {
        return new LottoShop(moneyWallet, lottoShopFactory);
    }

    public LottoWallet purchase() {
        return new LottoWallet(lottoShopFactory.createLottos(moneyWallet));
    }

}
