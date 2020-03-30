package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return lottoCount == lotto.lottoCount &&
                Objects.equals(generatedLottos, lotto.generatedLottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoCount, generatedLottos);
    }
}
