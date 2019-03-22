package lotto.domain.ticket;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    public void 생성_시_숫자_범위_넘어갈_경우_IllegalArgumentException() {
        // given
        int underMinNumber = LottoNumber.MIN_NUMBER - 1;
        int overMaxNumber = LottoNumber.MAX_NUMBER + 1;

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(underMinNumber));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(overMaxNumber));
    }

    @Test
    public void LottoNumber_get_메서드는_같은_LottoNumber_객체_사용() {
        // given
        int lottoNumber = LottoNumber.MAX_NUMBER;

        // when
        LottoNumber target = LottoNumber.get(lottoNumber);
        LottoNumber same = LottoNumber.get(lottoNumber);

        // then
        assertThat(target == same).isTrue();
    }
}
