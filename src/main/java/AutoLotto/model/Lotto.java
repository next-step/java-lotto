package autoLotto.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static autoLotto.model.LottoConstants.INVALID_LOTTO_NUMBERS;
import static autoLotto.model.LottoConstants.VALID_LOTTO_LENGTH;

public class Lotto {
    private Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        validateLotto(lotto);
        this.lotto = lotto;
    }

    public static Lotto createLottoFrom(List<String> lotto) {
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

    private static Set<LottoNumber> parseLottoNumbers(List<String> value) {
        return convertStringLottoToIntegerLotto(value);
    }

    private static Set<LottoNumber> convertStringLottoToIntegerLotto(List<String> input) {
        Set<LottoNumber> result = new LinkedHashSet<>();

        for (int i = 0; i < input.size(); i++) {
            LottoNumber number = convertStringToLottoNumber(input.get(i));
            result.add(number);
        }

        return result;
    }

    private static LottoNumber convertStringToLottoNumber(String numberAsString) {
        Integer number = Integer.parseInt(numberAsString);
        return new LottoNumber(number);
    }

    public Set<LottoNumber> getLotto() {
        return lotto;
    }

    public boolean containsNumber(int number) {
        return lotto.stream()
                .anyMatch(lottoNumber -> lottoNumber.isSameNumber(number));
    }
}
