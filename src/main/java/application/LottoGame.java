package application;

import domain.Lotto;
import domain.Winning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList();

    public LottoGame(int price, Random random) {
        IntStream.range(0, getCount(price)).boxed()
                .forEach(v -> lottos.add(new Lotto(random)));
    }

    private int getCount(int price) {
        return price / 1000;
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Integer> run(Winning winning) {
        List<Integer> results = new ArrayList();
        lottos.stream().forEach(v -> results.add(winning.compare(v.getNumbers())));
        return results;
    }
}


