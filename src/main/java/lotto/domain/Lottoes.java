package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottoes {

    private final List<Lotto> lottoes;

    public Lottoes(LottoCount lottoCount) {
        this.lottoes = setLottoes(lottoCount);
    }

    private List<Lotto> setLottoes(LottoCount lottoCount) {
        final List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < lottoCount.getCount(); i++) {
            Lotto lotto = new Lotto(GeneratorNumber.generateLottoNumbers());
            lottoes.add(lotto);
        }
        return lottoes;
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }
}
