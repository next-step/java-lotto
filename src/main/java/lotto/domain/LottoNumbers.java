package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int NUMBER_RANGE = 6;
    public static final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    private final List<LottoNumber> value;

    public LottoNumbers(List<LottoNumber> value) {
        valid(value);
        this.value = value;
    }

    public Rank getRank(LottoNumbers lottoNumbers) {

        int matchingNumberCount = (int) value.stream()
                .filter(lottoNumber -> lottoNumbers.getIntegerValues()
                        .contains(lottoNumber.getValue()))
                .count();

        return Rank.value(matchingNumberCount);
    }

    public List<Integer> getIntegerValues() {
        return value.stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getValue() {
        return value;
    }

    private void valid(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_ERROR);
        }

        if (isExistsDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_DUPLICATED);
        }
    }

    private boolean isExistsDuplicateNumber(List<LottoNumber> numbers) {
        return numbers.stream()
                .map(LottoNumber::getValue)
                .distinct()
                .count() != NUMBER_RANGE;
    }


}
