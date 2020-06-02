package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;
    private final int lottoCount;

    public Lotto(int lottoCount) {
        lottoNumbers = new ArrayList<>();
        this.lottoCount = lottoCount;
    }

    public void drawingLotto() {
        LottoMachine machine = new LottoMachine();
        for (int idx = 0; idx < lottoCount; idx++) {
            lottoNumbers.add(new LottoNumber(machine.raffle()));
        }
    }
}
