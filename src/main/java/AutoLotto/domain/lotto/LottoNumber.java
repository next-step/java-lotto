package AutoLotto.domain.lotto;

import java.util.List;
import java.util.Objects;
import static AutoLotto.utils.Constants.*;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

//    public LottoNumber makeLottoNumber(int lottoNumber) {
//        if (lottoNumber <= LOTTO_NUMBER_MAX && lottoNumber >= LOTTO_NUMBER_MIN) {
//            return new LottoNumber(lottoNumber);
//        }
//        return new LottoNumber(0);
//    }

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
