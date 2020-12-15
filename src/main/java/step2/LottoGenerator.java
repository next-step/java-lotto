package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoGenerator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private static final List<LottoNumber> LOTTO_NUMBER_POOL = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(toList());

    private LottoGenerator() {}

    private static List<LottoNumber> shuffledNumbers() {
        List<LottoNumber> numbers = LOTTO_NUMBER_POOL;

        Collections.shuffle(numbers);
        return numbers;
    }

    public static Lotto generateLotto() {
        Set<LottoNumber> lottoNumbers = shuffledNumbers().stream()
                .limit(6)
                .sorted()
                .collect(Collectors.toSet());

        return new Lotto(lottoNumbers);
    }

    public static List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();

        while(count > 0) {
            lottos.add(generateLotto());
            --count;
        }

        return lottos;
    }
}
