package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private List<Integer> lotto;
    private int matchCount = 0;
    private boolean matchBonus = false;

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

    public int countMatchCount(List<Integer> answerNumbers) {
        matchCount = (int) lotto.stream()
                .filter(answerNumbers::contains)
                .count();
        return matchCount;
    }

    public boolean checkBonusNumber(int bonusNumber) {
        matchBonus = lotto.stream()
                .anyMatch(number -> number == bonusNumber);
        return matchBonus;
    }
}
