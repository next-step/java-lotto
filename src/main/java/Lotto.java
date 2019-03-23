import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            new IllegalArgumentException();
        }
        this.lotto = lotto;
    }

    public int getMatchNumber(Lotto targetLotto) {
        return (int) targetLotto.lotto.stream()
                .filter(number -> this.lotto.contains(number))
                .count();
    }

    public boolean isMatchBonusNumber(LottoNumber bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

}
