package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.LOTTO_END_INDEX;
import static lotto.domain.LottoNumber.LOTTO_START_INDEX;

public class LottoMaker {

    private static final Random random = new Random();
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final String SPLIT_TOKEN = ",";

    private LottoMaker() {
    }

    public static List<LottoNumber> convertTextToLotto(String numbers) {
        return Arrays.stream(numbers.split(SPLIT_TOKEN))
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toUnmodifiableList());
    }
    public static List<Lotto> createAutoLotto(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generateLottoNumbers())
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    public static List<Lotto> convertPassiveLotto(List<String> lottoNumbers) {
        return lottoNumbers.stream()
                .map(numbers -> Arrays.stream(numbers.split(SPLIT_TOKEN))
                        .mapToInt(Integer::parseInt)
                        .mapToObj(LottoNumber::of)
                        .collect(Collectors.toList()))
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    private static List<LottoNumber> generateLottoNumbers() {
        return random.ints(LOTTO_START_INDEX, LOTTO_END_INDEX)
                .distinct()
                .limit(LOTTO_NUMBER_COUNT)
                .boxed()
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

}
