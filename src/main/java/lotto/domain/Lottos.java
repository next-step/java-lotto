package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    List<Lotto> lottos;
    NumbersGenerator numbers;
    int tryNum;

    public Lottos(int tryNum, NumbersGenerator numbers) {
        this.tryNum = tryNum / 1000;
        this.numbers = numbers;
        this.lottos = generateLotto();
    }

    private List<Lotto> generateLotto() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int num = 0; num < tryNum; num++) {
            lottoList.add(new Lotto(numbers));
        }
        return lottoList;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
