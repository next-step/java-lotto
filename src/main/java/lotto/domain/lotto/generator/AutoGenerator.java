package lotto.domain.lotto.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.number.Number;
import lotto.domain.lotto.number.Numbers;

public class AutoGenerator implements Generator {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LIMIT_MINIMUM_NUMBER = 1;
    private static final int LIMIT_MAXIMUM_NUMBER = 45;
    private static final List<Integer> numbers = IntStream.rangeClosed(LIMIT_MINIMUM_NUMBER,
        LIMIT_MAXIMUM_NUMBER).boxed().collect(Collectors.toList());

    @Override
    public List<Lotto> generateLottos(int count) {
        final List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateLotto()));
        }
        return lottos;
    }

    public Numbers generateLotto() {
        Collections.shuffle(numbers);
        final List<Integer> lottoNumbers = new ArrayList<>(numbers.subList(0, LOTTO_NUMBERS_SIZE));
        Collections.sort(lottoNumbers);
        return new Numbers(lottoNumbers.stream().map(Number::new).collect(Collectors.toList()));
    }
}
