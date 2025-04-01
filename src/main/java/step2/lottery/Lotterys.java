package step2.lottery;

import step2.generate.Generate;

import java.util.ArrayList;
import java.util.List;

public class Lotterys {
    private final List<Lottery> lottos;
    private static final int LOTTO_LENGTH = 6;
    public Lotterys(int count, Generate generate) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lottery(generate.makeNumbers(LOTTO_LENGTH)));
        }
    }

    public int length() {
        return lottos.size();
    }

    public Lottery getLottery(int index) {
        return lottos.get(index);
    }
}
