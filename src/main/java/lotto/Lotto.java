package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final int lottoCount;
    private List<LottoNumbers> generatedLottos;

    public Lotto(int lottoCount) {
        this.lottoCount = lottoCount;
        this.generatedLottos = new ArrayList<>();
    }

    public List<LottoNumbers> generateLottos() {
        for (int i = 0; i < lottoCount; i++) {
            generatedLottos.add(new LottoNumbers());
        }
        return generatedLottos;
    }
}
