package lotto;

import lotto.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.LottoNumber.LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 객체 생성")
    public void create(){
        int createLottoNumber = 1;
        LottoNumber lottoNumber = LottoNumber.lottoNumber(createLottoNumber);
        assertThat(lottoNumber.equals(LottoNumber.lottoNumber(createLottoNumber))).isTrue();
    }

    @Test
    @DisplayName("로또 번호 범위 체크")
    public void abnormalNumber(){
        assertThatIllegalArgumentException()
                .isThrownBy (() ->  LottoNumber.lottoNumber(0)).withMessage(LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);

        assertThatIllegalArgumentException()
                .isThrownBy (() ->  LottoNumber.lottoNumber(46)).withMessage(LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);
    }
}
