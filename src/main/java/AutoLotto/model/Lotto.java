package autoLotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static autoLotto.model.LottoConstants.*;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validateLotto(lotto);
        this.lotto = lotto;
    }

    public Lotto(String lotto) {
        this.lotto = parseLottoNumbers(lotto);
    }

    private void validateLotto(List<Integer> lotto) {
        if (!isValidLottoSize(lotto) || !isNotDuplicatedNumbers(lotto) || !isValidLottoNumbers(lotto)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS);
        }
    }

    private boolean isValidLottoSize(List<Integer> winNumbers) {
        return winNumbers.size() == VALID_LOTTO_LENGTH;
    }

    private boolean isNotDuplicatedNumbers(List<Integer> winNumbers) {
        Set<Integer> numbers = winNumbers.stream().collect(Collectors.toSet());
        return numbers.stream().distinct().count() == winNumbers.size();
    }

    private boolean isValidLottoNumbers(List<Integer> winNumbers) {
        Collections.sort(winNumbers);
        return isNumberInValidRange(winNumbers.get(0)) && isNumberInValidRange(winNumbers.get(VALID_LOTTO_LENGTH - 1));
    }

    private boolean isNumberInValidRange(int number) {
        return number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER;
    }

    private List<Integer> parseLottoNumbers(String value) {
        List<Integer> lotto = convertStringToIntegers(value);
        validateLotto(lotto);
        return lotto;
    }

    private List<Integer> convertStringToIntegers(String input) {
        String[] values = splitNumbersByComma(input);
        return stringsToListInteger(values);
    }

    private List<Integer> stringsToListInteger(String[] values) {
        return Arrays.stream(values)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private String[] splitNumbersByComma(String input) {
        return input.split(",");
    }

    public String toString() {
        return lotto.toString();
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
