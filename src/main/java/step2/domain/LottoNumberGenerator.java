package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    public static final int NUMBER_COUNT = 6;
    public static final int FINAL_NUMBER = 45;

    private LottoNumberGenerator() {}

    public static LottoNumbers generate() {
        List<LottoNumber> all = IntStream.rangeClosed(1, FINAL_NUMBER)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());
        Collections.shuffle(all);
        return new LottoNumbers(all.subList(0, NUMBER_COUNT));
    }
}
