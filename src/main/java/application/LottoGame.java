package application;

import domain.Lotto;
import domain.Winning;
import view.LottoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private List<Lotto> lottos = new ArrayList();
    private int price;

    public LottoGame(int price, Random random) {
        this.price = price;
        IntStream.range(0, getCount(price)).boxed()
                .forEach(v -> lottos.add(new Lotto(random)));
    }

    public List<LottoView> getLottos() {
        return lottos.stream().map(v -> new LottoView(v.getNumbers())).collect(Collectors.toList());
    }

    private int getCount(int price) {
        return price / 1000;
    }

    public int getSize() {
        return lottos.size();
    }

    public int getPrice() {
        return price;
    }

    public List<Integer> run(Winning winning) {
        List<Integer> results = new ArrayList();
        lottos.stream().forEach(v -> results.add(winning.compare(v.getNumbers())));
        return results;
    }
}


