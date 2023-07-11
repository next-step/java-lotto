package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoService {

    public LottoService() {
    }

    public Lottos buyLotto(Money money) {
        long countLotto = money.countLotto();
        List<Lotto> lottos = LongStream.range(0, countLotto)
                .mapToObj(l -> RandomGenerator.generateLotto())
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }
}
