package lotto.domain;

import lotto.asset.ExceptionConst;
import lotto.exception.BadNumOfLottoNoException;
import lotto.exception.LottoRangeException;
import lotto.exception.NanException;
import lotto.exception.NpeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoFactoryTest {

    @ParameterizedTest
    @DisplayName("6개의 로또 번호가 성공적으로 입력됨")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38", "7, 11, 16, 35, 36, 44"})
    void createLotto_success(String lottoStr) {
        assertThat(LottoFactory
                .createLotto(lottoStr)
                .toString()
        ).isEqualTo("[" + lottoStr + "]");
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 로또 번호가 입력되면 NanException 이 발생한다.")
    @ValueSource(strings = {"a, b, 3, 4, 5, 6", "8, 21, 2c, 4d, 42, 43", "3, 5, 11, 16, e2, f8", "7, g1, 16, 35, h6, 44"})
    void createLotto_nan(String lottoStr) {
        assertThatExceptionOfType(NanException.class)
                .isThrownBy(() -> LottoFactory.createLotto(lottoStr))
                .withMessage(ExceptionConst.NAN_MSG);
    }

    @ParameterizedTest
    @DisplayName("1 부터 45가 아닌 로또 번호가 입력되면 LottoRangeException 이 발생한다.")
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 46"})
    void createLotto_range(String lottoStr) {
        assertThatExceptionOfType(LottoRangeException.class)
                .isThrownBy(() -> LottoFactory.createLotto(lottoStr))
                .withMessage(ExceptionConst.LOTTO_RANGE_MSG);
    }

    @ParameterizedTest
    @DisplayName("로또 번호가 6개 입력되지 않으면, BadNumOfLottoNoException 이 발생한다.")
    @ValueSource(strings = {"a, b, 4, 5, 6", "8, 21, 42, 43", "e2, f8", ""})
    void createLotto_badNumOfLottoNo(String lottoStr) {
        assertThatExceptionOfType(BadNumOfLottoNoException.class)
                .isThrownBy(() -> LottoFactory.createLotto(lottoStr))
                .withMessage(ExceptionConst.BAD_NUM_OF_LOTTO_NO_MSG);
    }


    @Test
    @DisplayName("6개의 로또 번호가 성공적으로 입력됨")
    void createLotto_str_success() {
        assertThat(LottoFactory.createLottoFromStrList(Arrays.asList(new String[]{
                        "1", "2", "3", "4", "5", "6"
                })).toString()
        ).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("null 이 들어오면 NpeException 이 발생한다.")
    void createLotto_str_npe() {
        assertThatExceptionOfType(NpeException.class)
                .isThrownBy(() -> LottoFactory.createLottoFromStrList(Arrays.asList(new String[]{
                        null, null, null, null, null, null
                })))
                .withMessage(ExceptionConst.NPE_MSG);
    }

    @Test
    @DisplayName("숫자가 아닌 로또 번호가 입력되면 NanException 이 발생한다.")
    void createLotto_str_nan() {
        assertThatExceptionOfType(NanException.class)
                .isThrownBy(() -> LottoFactory.createLottoFromStrList(Arrays.asList(new String[]{
                        "a", "2", "c", "4", "e", "6"
                })))
                .withMessage(ExceptionConst.NAN_MSG);
    }

    @Test
    @DisplayName("1 부터 45가 아닌 로또 번호가 입력되면 LottoRangeException 이 발생한다.")
    void createLotto_str_range() {
        assertThatExceptionOfType(LottoRangeException.class)
                .isThrownBy(() -> LottoFactory.createLottoFromStrList(Arrays.asList(new String[]{
                        "1", "2", "3", "4", "5", "46"
                })))
                .withMessage(ExceptionConst.LOTTO_RANGE_MSG);
    }

    @Test
    @DisplayName("로또 번호가 6개 입력되지 않으면, BadNumOfLottoNoException 이 발생한다.")
    void createLotto_str_badNumOfLottoNo() {
        assertThatExceptionOfType(BadNumOfLottoNoException.class)
                .isThrownBy(() -> LottoFactory.createLottoFromStrList(Arrays.asList(new String[]{
                        "a", "b", "c"
                })))
                .withMessage(ExceptionConst.BAD_NUM_OF_LOTTO_NO_MSG);
    }


    @Test
    @DisplayName("6개의 로또 번호가 성공적으로 입력됨")
    void createLotto_int_success() {
        assertThat(LottoFactory.createLotto(Arrays.asList(new Integer[]{
                        1, 2, 3, 4, 5, 6
                })).toString()
        ).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("1 부터 45가 아닌 로또 번호가 입력되면 LottoRangeException 이 발생한다.")
    void createLotto_int_range() {
        assertThatExceptionOfType(LottoRangeException.class)
                .isThrownBy(() -> LottoFactory.createLotto(Arrays.asList(new Integer[]{
                        -1, -2, -3, 46, 47, 48
                })))
                .withMessage(ExceptionConst.LOTTO_RANGE_MSG);
    }

    @Test
    @DisplayName("로또 번호가 6개 입력되지 않으면, BadNumOfLottoNoException 이 발생한다.")
    void createLotto_int_badNumOfLottoNo() {
        assertThatExceptionOfType(BadNumOfLottoNoException.class)
                .isThrownBy(() -> LottoFactory.createLotto(Arrays.asList(new Integer[]{
                        46, 0, -1
                })))
                .withMessage(ExceptionConst.BAD_NUM_OF_LOTTO_NO_MSG);
    }
}
