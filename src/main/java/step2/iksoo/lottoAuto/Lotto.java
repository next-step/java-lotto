package step2.iksoo.lottoAuto;

import java.util.ArrayList;
import java.util.List;

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
}
