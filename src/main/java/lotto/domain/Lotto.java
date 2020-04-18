package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Integer> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public static Lotto of(List<Integer> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    private static void validateLottoNumbers(List<Integer> lottoNumbers) {
        checkLottoSize(lottoNumbers);
        checkDuplicatedNumber(lottoNumbers);
    }

    private static void checkDuplicatedNumber(List<Integer> lottoNumbers) {
        Set<Integer> numberSet = new HashSet<>(lottoNumbers);
        if (numberSet.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호 중복");
        }
    }

    private static void checkLottoSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호가 6개가 아닙니다");
        }
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

}
