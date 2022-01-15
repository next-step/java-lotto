package domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private List<Integer> lotto;
    private int matchCount = 0;

    public Lotto() {
        this(new LottoNumberAuto());
    }

    public Lotto(LottoNumber lottoNumber) {
        this.lotto = lottoNumber.generateLottoNumber();
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
