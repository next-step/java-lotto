package application;

import domain.Lotto;
import domain.LottoGenerator;
import domain.Score;
import domain.Winning;
import view.LottoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList();
    private int price;

    public LottoGame(int price, Random random) {
        this.price = price;
        IntStream.range(0, getCount(price)).boxed()
                .forEach(v -> lottos.add(new Lotto(LottoGenerator.run(random))));
    }

    public List<Integer> run(Winning winning) {
        return merge(compare(winning));
    }

    private List<Integer> compare(Winning winning) {
        return lottos.stream().map(lotto -> winning.compare(lotto)).collect(Collectors.toList());
    }

    private List<Integer> merge(List<Integer> result) {
        result.stream()
                .filter(matchCount -> LottoGameResult.isInRange(matchCount))
                .forEach(matchCount -> Score.plus(matchCount));
        return Score.getPoint();
    }

    public List<LottoView> getLottos() {
        return lottos.stream().map(v -> v.toView()).collect(Collectors.toList());
    }

    private int getCount(int price) {
        return price / LOTTO_PRICE;
    }

    public int getSize() {
        return lottos.size();
    }

    public int getPrice() {
        return price;
    }
}


