package step2;

import step2.shuffle.Shuffle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotterys {
    private List<Lottery> lottos;
    private static final int LOTTO_LENGTH = 6;
    public Lotterys(int count, Shuffle shuffle) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lottery(shuffle.makeRandomNumbers(LOTTO_LENGTH)));
        }
    }

    public int length() {
        return lottos.size();
    }

    public Lottery getLottery(int index) {
        return lottos.get(index);
    }
}
