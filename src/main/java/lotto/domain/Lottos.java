package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final static int PRICE = 1000;

    private List<Lotto> lottos;

    public Lottos(int payNum, NumbersGenerator lottoNumbers) {
        this.lottos = generateLotto(payNum / PRICE, lottoNumbers);
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    private List<Lotto> generateLotto(int tryNum, NumbersGenerator lottoNumbers) {
        List<Lotto> lottoList = new ArrayList<>();

        for (int num = 0; num < tryNum; num++) {
            lottoList.add(new Lotto(lottoNumbers.getNumbers()));
        }
        return lottoList;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
