package lotto.domain;

import util.ValidateUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class WinningLotto {
    private static final String COMMA_SEPARATOR = ",";
    private static final String VALID_INPUT_EMPTY_MESSAGE = "지난 주 당첨번호 입력 값이 없습니다.";
    private static final String VALID_SEPARAOR_MESSAGE = "구분자 ,가 없습니다.";
    private static final String VALID_NO_NUMBER_MESSAGE = "숫자가 아닙니다.";
    private static final String VALID_DUPLICATE_MESSAGE = "당첨번호와 중복이 불가합니다.";

    private final Lotto lotto;
    private LottoNumber bonus;

    public WinningLotto(String inputs) {
        validate(inputs);
        List<LottoNumber> numbers = Arrays.stream(inputs.split(COMMA_SEPARATOR))
                .map(input -> new LottoNumber(parseNumber(input)))
                .collect(toList());
        this.lotto = new Lotto(numbers);
    }

    public WinningLotto(String winningInputs, String bonusInput) {
        this(winningInputs);
        validateEmpty(bonusInput);
        LottoNumber bonus = new LottoNumber(parseNumber(bonusInput));
        validateDuplicate(bonus);
        this.bonus = bonus;
    }

    private void validateDuplicate(LottoNumber bonus) {
        List<LottoNumber> lottoNumbers = this.lotto.getLotto();
        if (lottoNumbers.contains(bonus)) {
            throw new IllegalArgumentException(VALID_DUPLICATE_MESSAGE);
        }
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALID_NO_NUMBER_MESSAGE);
        }
    }


    private void validate(String input) {
        validateEmpty(input);
        validateSeparator(input);
    }

    private void validateEmpty(String input) {
        if (ValidateUtils.isEmpty(input)) {
            throw new IllegalArgumentException(VALID_INPUT_EMPTY_MESSAGE);
        }
    }

    private void validateSeparator(String input) {
        if (!input.contains(COMMA_SEPARATOR)) {
            throw new IllegalArgumentException(VALID_SEPARAOR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    public List<LottoNumber> getNumbers() {
        return lotto.getLotto();
    }

    public LottoNumber getBonus() {
        return this.bonus;
    }
}
