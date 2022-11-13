package lotto;

import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    public static final LottoNumber lottoNumber1 = LottoNumber.of(1);
    public static final LottoNumber lottoNumber2 = LottoNumber.of(2);
    public static final LottoNumber lottoNumber3 = LottoNumber.of(3);
    public static final LottoNumber lottoNumber4 = LottoNumber.of(4);
    public static final LottoNumber lottoNumber5 = LottoNumber.of(5);
    public static final LottoNumber lottoNumber6 = LottoNumber.of(6);

    @Test
    void LottoNumberTest(){
        LottoNumber lottoNumberA = LottoNumber.of(1);
        assertThat(lottoNumberA.getNo()).isEqualTo(1);
    }

    @Test
    void LottoNumber생성실패() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber lottoNumberB = LottoNumber.of(null);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber lottoNumberC = LottoNumber.of(-1);
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber lottoNumberD = LottoNumber.of(46);
        });

    }
}
