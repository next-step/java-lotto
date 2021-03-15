package lotto;

import java.util.List;

public class Lotto {
    private List<LottoNumbers> lotto;

    public Lotto(int receiveMoney) {
        LottoNumbers lottoNumbers = new LottoNumbers();
        int count = lottoNumbers.howManyPass(receiveMoney);
        for (int i = 0; i < count; i++) {
            lotto.add(new LottoNumbers());
        }
    }
}
