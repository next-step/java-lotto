package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;
    private int matchCount = 0;

    public Lotto() {
        this(new LottoAutoGenerator());
    }

    public Lotto(LottoGenerator lottoGenerator) {
        this.lotto = lottoGenerator.generateLottoNumber();
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int checkLottoNumbers(List<Integer> answerNumbers) {
        matchCount = (int) lotto.stream()
                .filter(answerNumbers::contains)
                .count();
        return matchCount;
    }
}
