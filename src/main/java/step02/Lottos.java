package step02;

import java.util.ArrayList;
import java.util.List;

import static step02.LottoConfig.*;

public class Lottos {
    private List<LottoNumbers> lottos = new ArrayList<>();
    private LottoCount lottoCount;

    public Lottos(int count) {
        lottoCount = new LottoCount(count);
    }

    public LottoCount getLottoCount() {
        return lottoCount;
    }

    public void makeLotto(NumberRule numberRule) throws Exception {
        for (int i = 0; i < lottoCount.getCount(); i++) {
            lottos.add(new LottoNumbers(numberRule));
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoNumbers lottoNumbers : lottos) {
            stringBuilder.append(START_LOTTO_SYMBOL)
                    .append(lottoNumbers.toString())
                    .append(END_LOTTO_SYMBOL)
                    .append(LINE_BRAKE);
        }
        return stringBuilder.toString();
    }
}
