package lotto.domain;

import java.util.*;

import static lotto.domain.LottoNumber.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoNumber.LOTTO_MIN_NUMBER;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int LOTTO_PICK_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_PICK_COUNT) {
            throw new IllegalArgumentException("로또 번호는 반드시 6개여야 합니다.");
        }
        if (new HashSet<>(lottoNumbers).size() != LOTTO_PICK_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public static List<LottoNumber> generateLottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.add(LottoNumber.of(i));
        }

        Collections.shuffle(lottoNumbers);

        List<LottoNumber> result = new ArrayList<>();
        for (int i = 0; i < LOTTO_PICK_COUNT; i++) {
            result.add(lottoNumbers.get(i));
        }

        result.sort((n1, n2) -> Integer.compare(n1.getNumber(), n2.getNumber()));

        return result;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int countMatches(Set<LottoNumber> winningNumbers) {
        Set<LottoNumber> intersection = new HashSet<>(this.lottoNumbers);
        intersection.retainAll(winningNumbers);
        return intersection.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}
