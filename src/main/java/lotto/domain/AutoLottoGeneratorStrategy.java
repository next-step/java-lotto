package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AutoLottoGeneratorStrategy implements LottoGeneratorStrategy {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_MIN_VALUE = 1;
    private static final int LOTTO_MAX_VALUE = 45;

    private final int size;

    public AutoLottoGeneratorStrategy(int size) {
        this.size = size;
    }

    @Override
    public List<Lotto> generateLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (int cnt = 0; cnt < size; cnt++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int num = LOTTO_MIN_VALUE; num <= LOTTO_MAX_VALUE; ++num) {
            numbers.add(LottoNumber.from(num));
        }
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, LOTTO_SIZE);
        numbers.sort((Comparator.comparingInt(LottoNumber::getLottoNumber)));
        return new Lotto(numbers);
    }
}
