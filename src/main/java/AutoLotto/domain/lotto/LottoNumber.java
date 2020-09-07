package AutoLotto.domain.lotto;

import java.util.List;
import java.util.Objects;
import static AutoLotto.utils.Constants.*;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = checkLottoNumber(lottoNumber);
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    public static int checkLottoNumber(int lottoNumber) {
        if (lottoNumber <= LOTTO_NUMBER_MAX && lottoNumber >= LOTTO_NUMBER_MIN) {
            return lottoNumber;
        }
        throw new RuntimeException();
    }

    public int countMatch(UserLotto otherlotto) {
        return otherlotto.getUserLotto()
                .stream( ).filter(o -> isMatch(o))
                .mapToInt(i -> 1)
                .sum();
    }

    public int countMatchForTest(List<LottoNumber> otherLottoNumberList) {
        return otherLottoNumberList
                .stream( ).filter(o -> isMatch(o))
                .mapToInt(i -> 1)
                .sum();
    }

    private boolean isMatch(LottoNumber otherNumber) {
        return getLottoNumber() == otherNumber.getLottoNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        LottoNumber lottoNumber1 = (LottoNumber) o;
        return lottoNumber == lottoNumber1.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
