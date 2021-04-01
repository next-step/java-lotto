package step022;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<LottoNumbers> lottos = new ArrayList<>();
    private LottoCount lottoCount;

    public Lottos() {
        lottoCount = new LottoCount();
    }

    public Lottos(int count) {
        lottoCount = new LottoCount(count);
    }

    public LottoCount getLottoCount() {
        return lottoCount;
    }

    public void makeLotto(int count, MakeRandomNumberRule makeRandomNumberRule) {
        lottoCount.calculationCount(count);
        for (int i = 0; i < lottoCount.getCount(); i++) {
            lottos.add(new LottoNumbers().makedNumbers(makeRandomNumberRule));
        }
    }
}
