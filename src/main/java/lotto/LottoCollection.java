package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.NumberListGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoCollection {
    private final List<Lotto> lottoList = new ArrayList<>();
    private final int lottoCount;

    public LottoCollection(int lottoCount, NumberListGenerator numberListGenerator) {
        this.lottoCount = lottoCount;

        for (int i = 0; i < lottoCount; i++) {
            Set<Integer> generate = numberListGenerator.generate();
            lottoList.add(new Lotto(generate));
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public Set<Integer> getLottoNumbers(int index) {
        Lotto lotto = lottoList.get(index);
        return lotto.getNumbers();
    }

    public LottoResult getLottoResult(Lotto winnerLotto) {
        return new LottoResult();
    }
}
