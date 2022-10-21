package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final String SEPARATOR = ",";
    private static final String NULL_OR_BLANK_MESSAGE = "빈 문자를 입력하였습니다.";

    private LottoGenerator() {
    }

    static Set<LottoNumber> generate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumber.CACHE);
        Collections.shuffle(lottoNumbers);
        return new HashSet<>(lottoNumbers.subList(0, Lotto.VALID_SIZE));
    }

    static Set<LottoNumber> generate(String numbers) {
        if (isNullOrBlank(numbers)) {
            throw new IllegalArgumentException(NULL_OR_BLANK_MESSAGE);
        }
        List<String> values = Arrays.asList(numbers.split(SEPARATOR));
        return values.stream()
                .map(number -> LottoNumber.of(Integer.parseInt(number.trim())))
                .collect(Collectors.toSet());
    }

    static boolean isNullOrBlank(String numbers) {
        return numbers == null || numbers.isBlank();
    }
}
