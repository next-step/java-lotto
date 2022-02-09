package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class CorrectNumbers {

    private static final String DELIMITER_COMMA = ",";
    private static final int NUMBER_OF_LOTTO_BALL = 6;
    private static final String INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE = "구분자와 숫자만으로 이루어져야 합니다.";
    private static final String INVALID_NUMBER_COUNT_EXCEPTION_MESSAGE = "당첨 번호는 중복되지 않은 6개의 숫자 입니다.";
    private static final String DUPLICATE_NUMBER_EXCEPTION_MESSAGE = "로또 번호와 보너스 번호는 중복될 수 없습니다.";

    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public CorrectNumbers(final String inputWinningNumbers, final LottoNumber bonusNumber) {
        validateInputFormat(inputWinningNumbers);
        final Set<LottoNumber> winningNumbers = convertToLottoNumbers(inputWinningNumbers);

        validateWinningNumberCount(winningNumbers);
        validateDuplicateNumber(winningNumbers, bonusNumber);

        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateInputFormat(final String numbers) {
        if (!numbers.matches(getValidateRegex())) {
            throw new IllegalArgumentException(INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private String getValidateRegex() {
        return String.format("[0-9%s]+$", DELIMITER_COMMA);
    }

    private Set<LottoNumber> convertToLottoNumbers(final String winningNumbers) {
        String[] split = winningNumbers.split(DELIMITER_COMMA);

        return Arrays.stream(split)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    private void validateWinningNumberCount(final Set<LottoNumber> winningNumbers) {
        if (winningNumbers.size() != NUMBER_OF_LOTTO_BALL) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplicateNumber(final Set<LottoNumber> winningNumbers,
            final LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public Set<LottoNumber> getWinningNumbers() {
        return winningNumbers.get();
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
