package dev.dahye.lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.shuffle;

public class LottoNumberExtractor {
    public static final int START_INDEX = 0;
    public static final int LOTTO_SIZE = 6;

    private static final List<LottoNumber> numbers;

    static {
        numbers = new ArrayList<>();

        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            numbers.add(LottoNumber.of(i));
        }
    }

    private static LottoNumber get(Integer number) {
        return numbers.stream()
                .filter(lottoNumber -> lottoNumber.equals(LottoNumber.of(number)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 로또 번호입니다."));
    }

    public static List<LottoNumber> create() {
        List<LottoNumber> lottoNumbers = getNumbers();
        shuffle(lottoNumbers);

        return lottoNumbers.subList(START_INDEX, LOTTO_SIZE);
    }

    public static List<LottoNumber> convert(List<Integer> numbers) {
        validateLottoNumberIsNotNull(numbers);
        validateLottoNumberSize(numbers);

        return numbers.stream()
                .map(LottoNumberExtractor::get)
                .collect(Collectors.toList());
    }

    private static void validateLottoNumberIsNotNull(List<Integer> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.isEmpty()) {
            throw new IllegalArgumentException("lottoNumbers는 null이거나 빈 값일 수 없습니다.");
        }
    }

    private static void validateLottoNumberSize(List<Integer> lottoNumbers) {
        Set<Integer> deduplicatedNumbers = new HashSet<>(lottoNumbers);
        if (deduplicatedNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 티켓에는 중복된 숫자가 없는 6자리 숫자여야 합니다.");
        }
    }

    private static List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
