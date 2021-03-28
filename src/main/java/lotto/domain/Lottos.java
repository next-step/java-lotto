package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final static int PRICE = 1000;

    private List<Lotto> lottos;

    public Lottos(int payNum) {
        this.lottos = generateLotto(payNum / PRICE);
    }

    private List<Lotto> generateLotto(int payNum) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int num = 0; num < payNum; num++) {
            lottoList.add(new Lotto(new NumbersGenerator().getNumbers()));
        }
        return lottoList;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
