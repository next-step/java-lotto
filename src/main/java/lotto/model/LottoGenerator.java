package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoGenerator {

    private static final List<Integer> fullLottoNumbers = getFullLottoNumbers();

    public Lottos generateLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = getLottoCount(money);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }

    private int getLottoCount(Money money) {
        return money.getMoney() / Lotto.LOTTO_PRICE.getMoney();
    }

    private Lotto generateLotto() {
        Collections.shuffle(fullLottoNumbers);
        Set<Integer> lottoNumbers = fullLottoNumbers.stream()
                .limit(Lotto.LOTTO_SIZE)
                .collect(Collectors.toSet());
        return new Lotto(lottoNumbers);
    }

    private static List<Integer> getFullLottoNumbers() {
        return IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                .boxed()
                .collect(toList());
    }
}
