package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<LottoNumbers> lotto;
    private List<List<Integer>> markedLotto;

    public Lotto() {
        this.lotto = new ArrayList<>();
        markedLotto = new ArrayList<>();
    }

    public List<LottoNumbers> lotto() {
        return lotto;
    }

    public List<List<Integer>> markedLotto() {
        return markedLotto;
    }

    public void buy(int count) {
        for (int i = 0; i < count; i++) {
            lotto.add(new LottoNumbers());
        }
    }

    public void mark() {
        for (LottoNumbers numbers : lotto) {
            markedLotto.add(numbers.lottoNumbers());
        }
    }


}
