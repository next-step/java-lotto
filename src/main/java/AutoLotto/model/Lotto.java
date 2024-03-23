package autoLotto.model;

import java.util.LinkedHashSet;
import java.util.Set;

import static autoLotto.model.LottoConstants.INVALID_LOTTO_NUMBERS;
import static autoLotto.model.LottoConstants.VALID_LOTTO_LENGTH;

public class Lotto {
    private Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        validateLotto(lotto);
        this.lotto = lotto;
    }

    public static Lotto createLottoFrom(String lotto) {
        return new Lotto(parseLottoNumbers(lotto));
    }

    private void validateLotto(Set<LottoNumber> lotto) {
        if (!isValidLottoSize(lotto)) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS);
        }
    }

    private boolean isValidLottoSize(Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() == VALID_LOTTO_LENGTH;
    }

    private static Set<LottoNumber> parseLottoNumbers(String value) {
        Set<LottoNumber> result = convertStringToIntegers(value);
        return result;
    }

    private static Set<LottoNumber> convertStringToIntegers(String input) {
        String[] values = splitNumbersByComma(input);
        return stringsToSetInteger(values);
    }

    private static Set<LottoNumber> stringsToSetInteger(String[] values) {
        Set<LottoNumber> result = new LinkedHashSet<>();

        for (int i = 0; i < values.length; i++) {
            LottoNumber number = convertStringToLottoNumber(values[i]);
            result.add(number);
        }

        return result;
    }

    private static LottoNumber convertStringToLottoNumber(String numberAsString) {
        Integer number = Integer.parseInt(numberAsString);
        return new LottoNumber(number);
    }

    private static String[] splitNumbersByComma(String input) {
        return input.split(",");
    }

    public String toString() {
        return lotto.toString();
    }

    public Set<LottoNumber> getLotto() {
        return lotto;
    }

    public boolean containsNumber(int number) {
        return lotto.stream().anyMatch(lottoNumber -> lottoNumber.getLottoNumber() == number);
    }
}
