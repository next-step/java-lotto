package lotto.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoGenerator {

    private static final List<Integer> fullLottoNumbers = getFullLottoNumbers();

    public Lottos generateLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = money.getLottoCount();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }

    private Lotto generateLotto() {
        Collections.shuffle(fullLottoNumbers);
        Set<Integer> lottoNumbers = fullLottoNumbers.stream()
                .limit(Lotto.LOTTO_SIZE)
                .collect(Collectors.toCollection(TreeSet::new));
        return new Lotto(lottoNumbers);
    }

    private static List<Integer> getFullLottoNumbers() {
        return IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                .boxed()
                .collect(toList());
    }
}
