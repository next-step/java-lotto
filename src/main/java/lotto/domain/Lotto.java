package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import lotto.utils.Parser;

public class Lotto {

    private static final String DELIMITER_COMMA = ",";
    private static final int NUMBER_OF_LOTTO_BALL = 6;
    private static final String INVALID_INPUT_FORMAT_EXCEPTION_MESSAGE = "구분자와 숫자만으로 이루어져야 합니다.";
    private static final String INVALID_NUMBER_COUNT_EXCEPTION_MESSAGE = "당첨 번호는 중복되지 않은 6개의 숫자 입니다.";

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(final Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(final String inputLottoNumbers) {
        validateInputFormat(inputLottoNumbers);
        final Set<LottoNumber> lottoNumbers = convertToLottoNumbers(inputLottoNumbers);

        validateLottoNumberSize(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
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
                .map(value -> new LottoNumber(Parser.parseInt(value)))
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private void validateLottoNumberSize(final Set<LottoNumber> winningNumbers) {
        if (winningNumbers.size() != NUMBER_OF_LOTTO_BALL) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_EXCEPTION_MESSAGE);
        }
    }

    public int matchNumber(final Set<LottoNumber> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public Set<LottoNumber> get() {
        return this.lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
