package autoLotto.model;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String INVALID_LOTTO_NUMBERS = "로또 번호의 개수는 6개이며, 각 번호는 1 이상 45 이하의 값만 가능합니다.";
    private static final int VALID_LOTTO_LENGTH = 6;
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
