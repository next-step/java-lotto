package lotto.domain;

import java.util.Set;

public class Lotto {

    private final Set<Integer> autoLotto;

    private static final int LOTTO_SIZE = 6;

    public Lotto() {
        this(new LottoNumbers());
    }

    public Lotto(LottoNumbers lottoNumbers) {
        validate(lottoNumbers.getNumbers());
        this.autoLotto = lottoNumbers.getNumbers();
    }

    public Lotto(Set<Integer> autoLotto) {
        this.autoLotto = autoLotto;
    }

    public Set<Integer> getAutoLotto() {
        return autoLotto;
    }

    public int getMatchingCount(Set<Integer> winningNo) {
        return (int) autoLotto.stream()
                .filter(winningNo::contains)
                .count();
    }

    private void validate(Set<Integer> autoLotto) {
        if (autoLotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        if (autoLotto.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45사이여야 합니다.");
        }
    }
}
