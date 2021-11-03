package lotto.domains;

import utils.DataParser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;
    private final int lottosCnt;


    public Lottos(String moneyString) {
        this.lottosCnt = getLottosCnt(moneyString);
        this.lottos = readyLottos(lottosCnt);
    }

    public int getLottosCnt() {
        return lottosCnt;
    }

    private int getLottosCnt(String moneyString) {
        int money = DataParser.parseToInt(moneyString);
        return money / LOTTO_PRICE;
    }

    private List<Lotto> readyLottos(int lottosCnt) {
        return IntStream
                .range(0, lottosCnt)
                .mapToObj(i -> new Lotto())
                .collect(Collectors.toList());
    }

}
