package lotto.lotto.lottonumber;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final String LOTTO_NUMBERS_DIGIT_MESSAGE = "로또 번호는 6자리여야 합니다.";
    private static final String DUPLICATED_LOTTO_NUMBERS_MESSAGE = "로또 번호는 중복이 없어야 합니다.";
    private static final String DELIMITER = ",\\s|,";
    public static final int MAX = 6;

    private final List<LottoNumber> values;

    private LottoNumbers(List<LottoNumber> input) {
        this.values = input;
    }

    public static LottoNumbers from(List<Integer> input) {
        if (isValidDigits(input)) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_DIGIT_MESSAGE);
        }

        if (isDuplicated(input)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS_MESSAGE);
        }

        List<LottoNumber> lottoNumbers = input.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());

        return new LottoNumbers(lottoNumbers);
    }

    public static LottoNumbers from(String input) {
        String[] splitInput = input.split(DELIMITER);

        return LottoNumbers.from(
                Arrays.stream(splitInput)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }

    public List<Integer> values() {
        return values.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());
    }

    public long match(LottoNumbers winningNumbers) {
        return values.stream()
                .filter(winningNumbers.values::contains)
                .count();
    }

    public boolean isMatchedBonusNumber(LottoNumber bonusNumber) {
        return values.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
    }

    private static boolean isValidDigits(List<Integer> input) {
        return input == null || input.size() != MAX;
    }

    private static boolean isDuplicated(List<Integer> input) {
        return input.stream()
                .distinct()
                .count() != input.size();
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
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "values=" + values +
                '}';
    }
}
