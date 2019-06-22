package step2.iksoo.lottoAuto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final int LOTTO_SIZE = 6;

    private List<Integer> lottery;

    public Lotto() {
        lottery = new ArrayList<>();
        makeLotto();
    }

    private void makeLotto() {
        this.lottery = new RandomNumberCreator().getLotto(LOTTO_SIZE);
    }

    public boolean isNumSize(int numSize) {
        return this.lottery.size() == numSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return LOTTO_SIZE == lotto.LOTTO_SIZE &&
                Objects.equals(lottery, lotto.lottery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LOTTO_SIZE, lottery);
    }
}
