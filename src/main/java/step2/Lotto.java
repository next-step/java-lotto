package step2;

import java.util.List;
import java.util.Objects;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final String INVALID_LOTTO_SIZE_MESSAGE = "로또 번호 갯수는 6개 이어야 합니다.";
    public static final String INVALID_LOTTO_MIN_NUMBER_MESSAGE = "로또 번호는 1 보다 커야 합니다.";
    public static final String INVALID_LOTTO_MAX_NUMBER_MESSAGE = "로또 번호는 45 보다 작아야 합니다.";

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> lotto) {
        validateLottoSize(lotto);
        validateLottoNumbers(lotto);
        this.lottoNumbers = lotto;
    }

    private void validateLottoSize(List<Integer> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MESSAGE);
        }
    }

    private void validateLottoNumbers(List<Integer> lotto) {
        int min = LOTTO_MAX_NUMBER;
        int max = LOTTO_MIN_NUMBER;

        for (Integer lottoNumber : lotto) {
            if (lottoNumber < min) {
                min = lottoNumber;
            }
            if (lottoNumber > max) {
                max = lottoNumber;
            }
        }

        if (min < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_MIN_NUMBER_MESSAGE);
        }

        if (max > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_MAX_NUMBER_MESSAGE);
        }
    }

    public Rank match(Lotto winningLotto) {
        int matchCount = (int) lottoNumbers.stream()
            .filter(winningLotto.lottoNumbers::contains)
            .count();

        return Rank.of(matchCount);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto1.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
