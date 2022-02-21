package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottoes {

    private final List<Lotto> lottoes;

    public Lottoes(Money money) {
        this.lottoes = setLottoes(money);
    }

    private List<Lotto> setLottoes(Money money) {
        final List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < money.calculateCount(); i++) {
            Lotto lotto = new Lotto(GeneratorNumber.generateLottoNumbers());
            lottoes.add(lotto);
        }
        return lottoes;
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }
}
