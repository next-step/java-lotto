package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoSeller;
import lotto.domain.Wallet;
import lotto.vo.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoService {

    private final Money lottoPrice;
    private final LottoSeller lottoSeller;
    private final LottoGenerator lottoGenerator;
    private Wallet wallet;

    public LottoService(Money money) {
        NumberGenerateStrategy strategy = new RandomLottoNumberGenerateStrategy();
        int price = LottoRule.LOTTO_PRICE.getValue();
        this.lottoPrice = Money.create(BigDecimal.valueOf(price));
        this.lottoGenerator = LottoGenerator.create(strategy);
        this.lottoSeller = LottoSeller.create(lottoPrice, lottoGenerator);
        this.wallet = Wallet.create(money);
    }


    public Lottos buyLotto() {
        Money money = wallet.getMoneyToBuy();
        Lottos lottos = lottoSeller.buyLotto(money);
        wallet.saveLottos(lottos);
        return lottos;
    }

    public WinningHistory getWinningHistory(String winningLottoString) {
        Lotto winningLotto = createWinningLottoWithString(winningLottoString);
        return wallet.checkWinning(winningLotto);
    }

    private Lotto createWinningLottoWithString(String winningLottoString) {
        return Lotto.create(Arrays.stream(winningLottoString.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::getCachedLottoNumber)
                .collect(Collectors.toList()));
    }
}
