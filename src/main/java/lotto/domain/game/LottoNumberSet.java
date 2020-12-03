package lotto.domain.game;

import java.util.*;

/**
 * Created By mand2 on 2020-11-19.
 */
public class LottoNumberSet {

    private final Set<LottoNumber> lottoNumbers;

    public static final int VALID_LOTTO_SIZE = 6;
    public static final String MESSAGE_VALID_SIZE = "한 게임당 로또 번호를 중복없이 %d개 입력해 주세요.";

    private LottoNumberSet(Set<LottoNumber> lottoNumbers) {
        isValidSize(lottoNumbers.size());
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumberSet of(List<LottoNumber> lottoNumbers) {
        return new LottoNumberSet(Collections.unmodifiableSet(new TreeSet<>(lottoNumbers)));
    }

    public Set<LottoNumber> value() {
        return this.lottoNumbers;
    }

    public boolean contains(LottoNumber num) {
        return this.lottoNumbers.contains(num);
    }

    private static void isValidSize(int lottoNumberSize) {
        if (lottoNumberSize != VALID_LOTTO_SIZE) {
            throw new IllegalArgumentException(String.format(MESSAGE_VALID_SIZE, VALID_LOTTO_SIZE));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumberSet that = (LottoNumberSet) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return value().toString();
    }
}
