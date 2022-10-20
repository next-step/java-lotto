package lotto.domain;

import lotto.generator.ManualNumberGenerator;
import lotto.generator.NumberGenerator;
import lotto.generator.RandomNumberGenerator;

import java.util.*;

public class Lottos {

    public static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public int lottosSize() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public Lottos createAutoLottos(int amount) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        int n = amount / LOTTO_PRICE;
        for (int i = 0; i < n; i++) {
            this.lottos.add(new Lotto(numberGenerator));
        }
        return new Lottos(lottos);
    }

    public Lottos createManualLottos(List<String> numbers) {
        NumberGenerator numberGenerator;
        for (int i = 0; i < numbers.size(); i++) {
            numberGenerator = new ManualNumberGenerator(numbers.get(i));
            this.lottos.add(new Lotto(numberGenerator));
        }
        return new Lottos(lottos);
    }


}
