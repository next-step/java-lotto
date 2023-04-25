package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @Test
    void LottoNumber_생성() {
        //given
        LottoNumber lottoNumber = new LottoNumber(1);

        //when
        int value = lottoNumber.value();

        //then
        assertThat(value).isEqualTo(1);
    }

    @Test
    void LottoNumber_생성_인자값의_범위_예외() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(46))
                .withMessageContaining("로또 번호는 1에서 45사이의 숫자여야 합니다.");
    }
}
