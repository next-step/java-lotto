package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto() {
        this(new LottoAutoGenerator());
    }

    public Lotto(LottoGenerator lottoGenerator) {
        this.lotto = lottoGenerator.generateLottoNumber();
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }

    public int countMatchCount(List<Integer> answerNumbers) {
        return (int) lotto.stream()
                .filter(answerNumbers::contains)
                .count();
    }

    public boolean checkBonusNumber(int bonusNumber) {
        return lotto.stream()
                .anyMatch(number -> number == bonusNumber);
    }
}
