package step02;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<LottoNumbers> lottos = new ArrayList<>();
    private LottoCount lottoCount;

    public Lottos(int count) {
        lottoCount = new LottoCount(count);
    }

    public LottoCount getLottoCount() {
        return lottoCount;
    }

    public void makeLotto(RandomNumberRule makeRandomNumberRule) {
        for (int i = 0; i < lottoCount.getCount(); i++) {
            lottos.add(new LottoNumbers(makeRandomNumberRule));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoNumbers lottoNumbers : lottos) {
            stringBuilder.append("[").append(lottoNumbers.toString()).append("]").append("\n");
        }
        return stringBuilder.toString();
    }
}
