package lotto.model;

import lotto.model.generator.LottoGenerator;

import java.util.List;

public class LottoStore {

    public static LottoTicket buy(Wallet wallet, LottoGenerator lottoGenerator) {
        List<Lotto> lottos = lottoGenerator.generator();
        wallet.spendOnLotto(lottos.size());
        return LottoTicket.of(lottos);
    }
}
