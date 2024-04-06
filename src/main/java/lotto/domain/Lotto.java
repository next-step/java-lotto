package lotto.domain;

import java.util.Set;

import static lotto.domain.LottoFactory.LOTTO_SIZE;

public class Lotto {

    private final Set<Integer> lotto;

    public Lotto(NumbersGenerator lotto) {
        validate(lotto.getNumbers());
        this.lotto = lotto.getNumbers();
    }

    public Lotto(Set<Integer> lotto) {
        validate(lotto);
        this.lotto = lotto;
    }

    public Set<Integer> getLotto() {
        return lotto;
    }

    public int getMatchingCount(Lotto winningLotto) {
        return (int) lotto.stream()
                .filter(winningLotto.getLotto()::contains)
                .count();
    }

    public boolean contains(int bonusNumber) {
        return lotto.contains(bonusNumber);
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
