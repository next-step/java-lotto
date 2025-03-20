package lotto.model.generator;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoWallet;

public class LottoMachine {

    public LottoWallet getLottoNumbers(int size) {
        LottoGenerator lottoGenerator = new LottoGenerator(new LottoNumberGenerator());

        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            lottos.add(new Lotto(lottoGenerator.generate()));
        }

        return new LottoWallet(lottos);
    }
}
