package lotto.domains;

import utils.DataParser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;
    private final int numOfLotto;

    public Lottos(String moneyString) {
        this.numOfLotto = numOfLotto(moneyString);
        this.lottos = readyLottos(numOfLotto);
    }

    public int numOfLotto() {
        return numOfLotto;
    }

    private int numOfLotto(String moneyString) {
        int money = DataParser.parseToInt(moneyString);
        return money / LOTTO_PRICE;
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    private List<Lotto> readyLottos(int lottosCnt) {
        return IntStream
                .range(0, lottosCnt)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }

}
