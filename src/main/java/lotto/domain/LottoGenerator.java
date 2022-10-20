package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGenerator {
    private static final int VALID_SIZE = 6;
    private static final String SEPARATOR = ",";
    private static final String NULL_OR_BLANK_MESSAGE = "빈 문자를 입력하였습니다.";
    private static final String INVALID_SIZE_MESSAGE = "로또 번호 1~45 사이 자연수 6개 입력해주세요. (" + SEPARATOR + " 기준으로 )";

    private LottoGenerator() {
    }

    static Set<LottoNumber> generate() {
        List<LottoNumber> lottoNumbers = new ArrayList<>(LottoNumber.CACHE);
        Collections.shuffle(lottoNumbers);
        return new HashSet<>(lottoNumbers.subList(0, VALID_SIZE));
    }

    static Set<LottoNumber> toLotto(String numbers) {
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

    static void validateSize(Set<LottoNumber> lotto) {
        if (isInvalidSize(lotto)) {
            throw new IllegalArgumentException(INVALID_SIZE_MESSAGE);
        }
    }

    private static boolean isInvalidSize(Set<LottoNumber> numbers) {
        return VALID_SIZE != numbers.stream()
                .distinct()
                .count();
    }
}
