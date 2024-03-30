package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> autoLotto;
    private int matchingCount;

    private static final int LOTTO_SIZE = 6;

    public Lotto(LottoNumbers lottoNumbers) {
        this.autoLotto = validateSize(lottoNumbers.getNumbers());
        this.matchingCount = 0;
    }

    public Lotto(List<Integer> autoLotto) {
        this.autoLotto = autoLotto;
        this.matchingCount = 0;
    }

    public List<Integer> getAutoLotto() {
        return autoLotto;
    }

    public int getMatchingCount(List<Integer> winningNo) {
        return this.matchingCount = (int) autoLotto.stream()
                .filter(winningNo::contains)
                .count();
    }

    public List<Integer> validateSize(List<Integer> autoLotto) {
        if (autoLotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        return autoLotto;
    }
}
