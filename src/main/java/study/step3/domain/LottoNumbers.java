package study.step3.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final String LOTTO_NUMBER_DUPLICATE_ERROR = "중복된 당첨 번호가 존재합니다.";
    private static final String LOTTO_NUMBER_COUNT_ERROR = "당첨 번호는 6개 입력해주세요.";
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        isLottoNumberCount(lottoNumbers);
        isDuplicateNumbers(lottoNumbers);
        this.numbers = createLottoNumbers(lottoNumbers);
    }

    public LottoNumbers(int inputBonusNumber) {
        this.numbers = createBonusNumber(inputBonusNumber);
    }

    public List<LottoNumber> readOnlyNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private List<LottoNumber> createBonusNumber(int inputBonusNumber) {
        return Arrays.asList(new LottoNumber(inputBonusNumber));
    }

    private void isLottoNumberCount(List<Integer> result) {
        if (result.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_ERROR);
        }
    }

    private void isDuplicateNumbers(List<Integer> result) {
        int count = (int) result.stream()
                .distinct()
                .count();
        if (count != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
