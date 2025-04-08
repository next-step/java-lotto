package lotto.domain.service;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoWallet;

import java.util.List;


public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoWallet buyLottos(int purchaseAmount) {
        int numLottos = purchaseAmount / LOTTO_PRICE;
        LottoWallet lottoWallet = new LottoWallet();
        for (int i = 0; i < numLottos; i++) {
            List<LottoNumber> numbers = this.lottoNumberGenerator.generate();
            lottoWallet.addLotto(new LottoTicket(numbers));
        }
        return lottoWallet;
    }
}
