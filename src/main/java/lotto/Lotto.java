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
        generateLottos();
    }

    private void generateLottos() {
        for (int i = 0; i < lottoCount; i++) {
            generatedLottos.add(new LottoNumbers());
        }
    }

    public List<LottoNumbers> getGeneratedLottos() {
        return new ArrayList<>(generatedLottos);
    }

    public int getLottoCount() {
        return lottoCount;
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
