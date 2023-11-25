package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class LottoNumbers {
    private static final int COUNT = 6;
    private static final List<LottoNumber> RANGE_LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER).boxed().map(LottoNumber::new).collect(Collectors.toList());

    private final Set<LottoNumber> lottoNumbers;

    // 랜덤 생성
    public LottoNumbers() {
        Collections.shuffle(RANGE_LOTTO_NUMBERS);
        this.lottoNumbers = new TreeSet<>(RANGE_LOTTO_NUMBERS.subList(0, 6));
    }

    // 수동 생성
    public LottoNumbers(List<Integer> input) {
        this.validateCount(input);
        this.lottoNumbers = input.stream().map(LottoNumber::new).sorted().collect(Collectors.toSet());
    }

    public long compareNumbers(LottoNumbers targetLottoNumbers) {
        return this.lottoNumbers.stream().filter(lottoNumber -> isNumberMatched(targetLottoNumbers, lottoNumber)).count();
    }

    private boolean isNumberMatched(LottoNumbers targetLottoNumbers, LottoNumber lottoNumber) {
        return targetLottoNumbers.lottoNumbers.stream().anyMatch(target -> target.compareTo(lottoNumber) == 0);
    }

    public Set<LottoNumber> numbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    private void validateCount(List<Integer> input) {
        if (input.size() != COUNT) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요.");
        }
    }
}
