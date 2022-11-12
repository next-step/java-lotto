package step3;

import java.util.Set;

public class Lotto {
    private Set<Integer> lotto;

    public Lotto(Set<Integer> lotto) {
        LottoValidator.validateLottoSize(lotto.size());
        LottoValidator.validateLottoRange(lotto);
        this.lotto = lotto;
    }

    public boolean checkBonus(int bonus) {
        return lotto.contains(bonus);
    }

    public int count(Lotto other) {
        return (int) other.lotto.stream()
                .filter(this::isExist)
                .count();
    }

    public boolean isExist(Integer lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
