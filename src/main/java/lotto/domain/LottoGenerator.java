package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    public List<Lotto> generateLottos(Budget budget) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < budget.canBuyQuantity(); i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public Lotto generateLotto() {
        List<Integer> lottoNumbers = initialLottoRange();
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(0, 6);
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private List<Integer> initialLottoRange() {
        return IntStream.range(1, 46).boxed().collect(Collectors.toList());
    }
}
