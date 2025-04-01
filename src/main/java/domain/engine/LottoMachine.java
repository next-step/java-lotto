package domain.engine;

import domain.generator.LottoNumberGenerator;
import domain.model.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<LottoNumbers> buyLottos(int purchaseAmount) {
        int numLottos = purchaseAmount / LOTTO_PRICE;
        List<LottoNumbers> lottos = new ArrayList<>();
        for (int i = 0; i < numLottos; i++) {
            lottos.add(new LottoNumbers(this.lottoNumberGenerator.generate()));
        }
        return lottos;
    }
}
