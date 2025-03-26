package step2.domain;

import java.util.Set;

public class Lotto {
    private final Set<LottoNum> lotto;

    public Lotto(Set<LottoNum> lotto) {
        this.lotto = lotto;
        valid(lotto);
    }

    private void valid(Set<LottoNum> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException("로또의 숫자 개수는 6개여야 합니다.");
        }
    }

    public int countMatch(Set<LottoNum> winningNums) {
        return (int) lotto.stream()
                .filter(winningNums::contains)
                .count();
    }

    public Set<LottoNum> getNumbers() {
        return lotto;
    }

    @Override
    public String toString() {
        return lotto.toString();

    }
}
