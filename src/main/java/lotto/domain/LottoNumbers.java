package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class LottoNumbers {
    private static final int COUNT = 6;
    public static final String DELIMITER = ",";
    public static final String NUMBER_COMMA_BLANK_ONLY = "^[0-9,\\s]+$";
    private static final List<LottoNumber> RANGE_LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER).boxed().map(LottoNumber::new).collect(Collectors.toList());

    private List<LottoNumber> lottoNumbers;

    // 랜덤 생성
    public LottoNumbers() {
        this.lottoNumbers = new ArrayList<>(RANGE_LOTTO_NUMBERS);
        Collections.shuffle(this.lottoNumbers);
        this.lottoNumbers = this.lottoNumbers.subList(0, 6);
    }

    // 수동 생성
    public LottoNumbers(String input) {
        this.validateValue(input);

        this.lottoNumbers = Stream.of(input.split(DELIMITER))
                .map(number -> new LottoNumber(Integer.parseInt(number.trim())))
                .collect(Collectors.toList());

        this.validateCount();
    }

    public long compareNumbers(LottoNumbers targetLottoNumbers) {
        return this.lottoNumbers.stream().filter(lottoNumber -> targetLottoNumbers.lottoNumbers.stream().anyMatch(target -> target.compareTo(lottoNumber) == 0)).count();
    }

    public List<LottoNumber> numbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    private void validateValue(String input) {
        if (!input.matches(NUMBER_COMMA_BLANK_ONLY)) {
            throw new IllegalArgumentException("유효하지 않은 입력값입니다.");
        }
    }

    private void validateCount() {
        if (lottoNumbers.size() != COUNT) {
            throw new IllegalArgumentException("숫자 6개를 입력해주세요.");
        }
    }
}
