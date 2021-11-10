package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoSeller;
import lotto.domain.Wallet;
import lotto.vo.*;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LottoService {

    private final Money lottoPrice;
    private final LottoSeller lottoSeller;
    private final LottoGenerator lottoGenerator;
    private Wallet wallet;

    public LottoService() {
        NumberGenerateStrategy strategy = new RandomLottoNumberGenerateStrategy();
        this.lottoPrice = Money.create(LottoRule.LOTTO_PRICE.getValue());
        this.lottoGenerator = LottoGenerator.create(strategy);
        this.lottoSeller = LottoSeller.create(lottoPrice, lottoGenerator);
    }


    public Lottos buyLotto(Money money) {
        Lottos lottos = lottoSeller.buyLotto(money);
        wallet = Wallet.create(lottos, money);
        return lottos;
    }

    public WinningHistory getWinningHistory(String winningLottoString) {
        Lotto winningLotto = createWinningLottoWithString(winningLottoString);
        return wallet.checkWinning(winningLotto);
    }

    private Lotto createWinningLottoWithString(String winningLottoString) {
        return Lotto.create(Arrays.stream(winningLottoString.split(","))
                .map(LottoNumber::create)
                .collect(Collectors.toList()));
    }
}
