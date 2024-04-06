package lotto.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.LOTTO_NUMBER_LIMIT;
import static lotto.domain.LottoNumber.LOTTO_END_INDEX;
import static lotto.domain.LottoNumber.LOTTO_START_INDEX;

public class AutoLottoMaker implements LottoMaker {

    private static final Random random = new Random();
    private final Integer count;
    public AutoLottoMaker(Integer count) {
        this.count = count;
    }

    @Override
    public List<Lotto> create() {
        return IntStream.range(0, count)
                .mapToObj(i -> generateLottoNumbers())
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> generateLottoNumbers() {
        return random.ints(LOTTO_START_INDEX, LOTTO_END_INDEX)
                .distinct()
                .limit(LOTTO_NUMBER_LIMIT)
                .boxed()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }
}
