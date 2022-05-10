package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    private final List<Lotto> lottoList;

    private Game(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Game pay(int price) {
        int count = price / 1000;
        List<Lotto> lottoList = Stream
                .generate(Lotto::auto)
                .limit(count)
                .collect(Collectors.toList());

        return new Game(lottoList);
    }

    public Prize findPrize(Lotto beforeLotto) {

        return Prize.work(beforeLotto, this.getLottoList());
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
}
