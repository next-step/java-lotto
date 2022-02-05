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

    private Lotto(List<Integer> lotto) {
        this(() -> lotto);
    }

    public static Lotto from(List<Integer> lotto) {
        return new Lotto(lotto);
    }

    public List<Integer> getLotto() {
        return Collections.unmodifiableList(lotto);
    }

    public int countMatch(List<Integer> answerNumbers) {
        return (int) lotto.stream()
                .filter(answerNumbers::contains)
                .count();
    }

    public boolean checkBonusNumber(int bonusNumber) {
        return lotto.contains(bonusNumber);
    }
}
