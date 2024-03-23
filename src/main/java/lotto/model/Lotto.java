package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validateLotto(lotto);
        this.lotto = lotto;
    }

    public Lotto(String lotto) {
        this.lotto = parseLottoNumbers(lotto);
    }

    private void validateLotto(List<Integer> lotto) {
        if (!isValidLottoSize(lotto) || !isNotDuplicatedNumbers(lotto) || !isValidLottoNumbers(lotto)) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개이며, 각 번호는 1 이상 45 이하의 값만 가능합니다.");
        }
    }

    private boolean isValidLottoSize(List<Integer> winNumbers) {
        return winNumbers.size() == 6;
    }

    private boolean isNotDuplicatedNumbers(List<Integer> lottoNumers) {
        Set<Integer> numbers = lottoNumers.stream().collect(Collectors.toSet());
        return numbers.stream().distinct().count() == lottoNumers.size();    }

    private boolean isValidLottoNumbers(List<Integer> lottoNumers) {
        Collections.sort(lottoNumers);
        return isNumberInValidRange(lottoNumers.get(0)) && isNumberInValidRange(lottoNumers.get(6 - 1));
    }

    private boolean isNumberInValidRange(int number) {
        return number >= 1 && number <= 45;
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
        return Arrays.stream(values).map(Integer::valueOf).collect(Collectors.toList());
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
