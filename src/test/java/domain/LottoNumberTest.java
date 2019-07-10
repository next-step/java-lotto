package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LottoNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호는_최대값보다_클_수_없다() {
        LottoNumber.of(LottoNumber.LOTTO_MAX_NUMBER + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호는_최소값보다_작을_수_없다() {
        LottoNumber.of(LottoNumber.LOTTO_MIN_NUMBER - 1);
    }

    @Test
    public void 숫자같은_경우_같다() {
        //given
        int number = 5;

        // then
        assertEquals(LottoNumber.of(number), LottoNumber.of(number));
    }

    @Test
    public void 숫자_문자열로_로또_번호를_생성가능하다() {
        // given
        int number = 20;
        LottoNumber lottoNumber = LottoNumber.of(String.valueOf(number));

        // then
        assertTrue(lottoNumber.equals(LottoNumber.of(number)));
    }
}
