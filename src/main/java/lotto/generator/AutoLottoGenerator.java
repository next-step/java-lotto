package lotto.generator;

import lotto.Lotto;
import lotto.LottoNumber;
import lotto.Lottos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class AutoLottoGenerator implements LottoGenerator {
    private static List<LottoNumber> baseNumbers =
            IntStream.range(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                    .mapToObj(LottoNumber::valueOf)
                    .collect(Collectors.toList());
    private int number;

    public AutoLottoGenerator(int number) {
        this.number = number;
    }

    private Lotto generateLotto() {
        Collections.shuffle(baseNumbers);
        return new Lotto(new HashSet<>(baseNumbers.subList(BASE_INDEX, Lotto.SIZE_LIMIT)));
    }

    @Override
    public Lottos generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottos.add(generateLotto());
        }
        return new Lottos(lottos);
    }
}
