package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    private final List<Integer> lottoNumbers;

    public LottoGenerator() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(i);
        }
    }

    public List<Lotto> generateLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / 1000; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        Collections.shuffle(lottoNumbers);
        return new Lotto(lottoNumbers.subList(0, 6));
    }
}
