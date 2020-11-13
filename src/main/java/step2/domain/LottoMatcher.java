package step2.domain;

import step2.exception.ValidEmptyException;
import step2.exception.ValidNullException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMatcher {
    private static final String DELIMITER_LOTTO = ",";
    private final List<Integer> lottoNumbers;

    public LottoMatcher(String input) {

        validEmpty(input);
        validNull(input);

        lottoNumbers = Arrays.stream(separateLottoNumber(input))
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
    }

    private String[] separateLottoNumber(String input) {
        return input.split(DELIMITER_LOTTO);
    }

    private void validNull(String input) {
        if (input == null) {
            throw new ValidNullException();
        }
    }

    private void validEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new ValidEmptyException();
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

}
