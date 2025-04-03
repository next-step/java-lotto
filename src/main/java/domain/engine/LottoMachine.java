package domain.engine;

import domain.generator.LottoNumberGenerator;
import domain.model.LottoNumbers;
import domain.model.LottoWallet;


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
            lottoWallet.addLotto(new LottoNumbers(this.lottoNumberGenerator.generate()));
        }
        return lottoWallet;
    }
}
