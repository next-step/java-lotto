package lotto.domain;

import lotto.asset.ExceptionConst;
import lotto.asset.LottoConst;
import lotto.exception.BadNumOfLottoNoException;
import lotto.exception.LottoRangeException;
import lotto.exception.NpeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoTest {

    @ParameterizedTest
    @DisplayName("숫자를 add 한 만큼 사이즈가 증가해야한다.")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void getSize_int(int loop) {
        Lotto lotto = new Lotto();
        for (int i = 1; i <= loop; i++) {
            lotto.add(i);
        }
        assertThat(lotto.getSize())
                .isEqualTo(loop);
    }

    @ParameterizedTest
    @DisplayName("문자를 add 한 만큼 사이즈가 증가해야한다.")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void getSize_str(int loop) {
        Lotto lotto = new Lotto();
        for (int i = 1; i <= loop; i++) {
            lotto.add(Integer.toString(i));
        }
        assertThat(lotto.getSize())
                .isEqualTo(loop);
    }

    @Test
    @DisplayName("로또 숫자를 6개 보다 많이 추가하면, BadNumOfLottoNoException 이 발생한다.")
    void add() {
        Lotto lotto = new Lotto();
        for (int i = 1; i <= LottoConst.NUM_OF_LOTTO_NO; i++) {
            lotto.add(i);
        }
        assertThatExceptionOfType(BadNumOfLottoNoException.class)
                .isThrownBy(() -> lotto.add(7))
                .withMessage(ExceptionConst.BAD_NUM_OF_LOTTO_NO_MSG);
    }

    @Test
    @DisplayName("null 을 add 하면, NpeException 이 발생한다.")
    public void constructor_null() {
        Lotto lotto = new Lotto();
        assertThatExceptionOfType(NpeException.class)
                .isThrownBy(() -> lotto.add(null))
                .withMessage(ExceptionConst.NPE_MSG);
    }

    @ParameterizedTest
    @DisplayName("1부터 45가 아닌 숫자를 add 하면, LottoRangeException 이 발생한다.")
    @ValueSource(ints = {-1, 0, 46})
    public void constructor_int_fail(int lottoNo) {
        Lotto lotto = new Lotto();
        assertThatExceptionOfType(LottoRangeException.class)
                .isThrownBy(() -> lotto.add(lottoNo))
                .withMessage(ExceptionConst.LOTTO_RANGE_MSG);
    }

    @ParameterizedTest
    @DisplayName("1부터 45가 아닌 숫자 문자를 add 하면, LottoRangeException 이 발생한다.")
    @ValueSource(strings = {"-1", "0", "46"})
    public void constructor_str_fail(String lottoNo) {
        Lotto lotto = new Lotto();
        assertThatExceptionOfType(LottoRangeException.class)
                .isThrownBy(() -> lotto.add(lottoNo))
                .withMessage(ExceptionConst.LOTTO_RANGE_MSG);
    }

    @Test
    void testToString() {
        Lotto lotto = new Lotto();
        for (int i = 1; i <= 6; i++) {
            lotto.add(i);
        }
        String expected = "[1, 2, 3, 4, 5, 6]";
        assertThat(lotto.toString())
                .isEqualTo(expected);
    }

    @Test
    void testEquals() {
        Lotto lotto1 = new Lotto();
        for (int i = 1; i <= 6; i++) {
            lotto1.add(i);
        }
        Lotto lotto2 = new Lotto();
        for (int i = 6; i >= 1; i--) {
            lotto2.add(i);
        }
        assertThat(lotto1)
                .isEqualTo(lotto2);
    }

    @Test
    void testHashCode() {
        Lotto lotto1 = new Lotto();
        for (int i = 1; i <= 6; i++) {
            lotto1.add(i);
        }
        Lotto lotto2 = new Lotto();
        for (int i = 6; i >= 1; i--) {
            lotto2.add(i);
        }
        assertThat(lotto1.hashCode())
                .isEqualTo(lotto2.hashCode());
    }
}
