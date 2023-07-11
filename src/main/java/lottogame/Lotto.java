package lottogame;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> lotto;

    public Lotto(List<Integer> values) {
        validate(values);
        this.lotto = convertToLottoNumbers(values);
    }

    private void validate(List<Integer> values) {
        validateSize(values);
        validateDuplicate(values);
    }

    private static void validateDuplicate(List<Integer> values) {
        HashSet<Integer> distinctValues = new HashSet<>(values);
        if (distinctValues.size() != values.size()) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야합니다");
        }
    }

    private void validateSize(List<Integer> values) {
        if (values.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야합니다");
        }
    }

    private List<LottoNumber> convertToLottoNumbers(List<Integer> values) {
        return values.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public boolean hasLottoNumber(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }
}
