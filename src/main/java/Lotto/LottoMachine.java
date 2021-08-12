package Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private NumberGenerator numberGenerator;

    public LottoMachine(NumberGenerator numberGenerator) {

        this.numberGenerator = numberGenerator;
    }

    public List<Lotto> createLotto(Money money) {

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.getUnit(); i++) {

            lottos.add(new Lotto(new LotterNumbers(numberGenerator.generate())));
        }

        return lottos;

    }

}




