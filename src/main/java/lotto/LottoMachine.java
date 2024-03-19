package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final int number;
    private final List<LottoGenerator> lottoGenerators;

    public LottoMachine(int number) {
        this.number = number;
        this.lottoGenerators = new ArrayList<>();
    }

    public void makeLottos() {
        for (int i = 0; i < number; i++) {
            lottoGenerators.add(new LottoGenerator());
        }
    }

    public List<LottoGenerator> getLottoGenerators() {
        return lottoGenerators;
    }
}
