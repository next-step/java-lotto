package lotto.domain;

import lotto.generator.ManualNumberGenerator;
import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;

import java.util.*;

public class Lottos {

    public static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int lottosSize() {
        return this.lottoList.size();
    }

    public List<Lotto> getLottoList() {
        return this.lottoList;
    }

    public Lottos createAutoLottos(int amount) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        int n = amount / LOTTO_PRICE;
        for (int i = 0; i < n; i++) {
            this.lottoList.add(new Lotto(numberGenerator));
        }
        return this;
    }

    public Lottos createManualLottos(List<String> numbers) {
        NumberGenerator numberGenerator;
        for (int i = 0; i < numbers.size(); i++) {
            numberGenerator = new ManualNumberGenerator(numbers.get(i));
            this.lottoList.add(new Lotto(numberGenerator));
        }
        return this;
    }


}
