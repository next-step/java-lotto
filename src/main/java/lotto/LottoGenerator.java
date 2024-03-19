package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    private final int number;

    public LottoGenerator(int number) {
        this.number = number;
    }

    public List<LottoNumberGenerator> getLottoNumberGenerators() {
        List<LottoNumberGenerator> lottoNumberGenerators = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottoNumberGenerators.add(new LottoNumberGenerator());
        }
        return lottoNumberGenerators;
    }
}
