package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoNumbers {
    public static final int COUNT = 6;
    private static final List<LottoNumber> RANGE_LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER).boxed().map(LottoNumber::new).collect(Collectors.toList());

    Set<LottoNumber> numbers;

    // 랜덤 생성
    public LottoNumbers() {
        Collections.shuffle(RANGE_LOTTO_NUMBERS);
        this.numbers = new TreeSet<>(RANGE_LOTTO_NUMBERS.subList(0, COUNT));
    }

    // 수동 생성
    public LottoNumbers(List<Integer> numbers) {
        this.validateCount(numbers);
        this.numbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toSet());
    }

    public boolean isNumberMatched(LottoNumber lottoNumber) {
        return this.numbers.stream().anyMatch(target -> target.compareTo(lottoNumber) == 0);
    }

    Set<LottoNumber> numbers() {
        return Collections.unmodifiableSet(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }

    void validateCount(List<Integer> input) {
        if (input.size() != COUNT) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요.");
        }
    }

}
