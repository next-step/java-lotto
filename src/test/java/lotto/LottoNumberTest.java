package lotto;

import lotto.exception.WrongNumberException;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("로또 번호 객체 생성")
    public void create(){
        int createLottoNumber = 1;
        LottoNumber lottoNumber = LottoNumber.valueOf(createLottoNumber);
        assertThat(lottoNumber.equals(LottoNumber.valueOf(createLottoNumber))).isTrue();
    }

    @Test
    @DisplayName("로또 번호에 문자열 입력")
    public void notNumber(){
        String createLottoNumber = "일번";
        assertThatThrownBy (() ->  LottoNumber.valueOf(createLottoNumber)).isInstanceOf(WrongNumberException.class);
    }

    @Test
    @DisplayName("로또 번호 범위 체크")
    public void abnormalNumber(){
        assertThatThrownBy (() ->  LottoNumber.valueOf(0)).isInstanceOf(WrongNumberException.class);

        assertThatThrownBy (() ->  LottoNumber.valueOf(46)).isInstanceOf(WrongNumberException.class);
    }
}
