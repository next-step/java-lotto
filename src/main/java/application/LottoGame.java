package application;

import domain.Lotto;
import domain.LottoGenerator;
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
                .forEach(v -> lottos.add(new Lotto(LottoGenerator.run(random))));
    }

    public List<LottoView> getLottos() {
        return lottos.stream().map(v -> v.toView()).collect(Collectors.toList());
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
        lottos.stream().forEach(lotto -> results.add(winning.compare(lotto)));
        return results;
    }
}


