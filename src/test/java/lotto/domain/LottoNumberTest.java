package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    private static final String OUT_OF_RANGE_EXCEPTION = "로또 숫자는 1에서 45까지 입니다.";

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 6, 7, 8, 33, 45})
    @DisplayName("숫자와 일치하는 번호를 가진 로또넘버 객체를 반환한다.")
    void lotto_number_with_same_number(int num) {
        //given

        //when
        LottoNumber lottoNumber = LottoNumber.of(num);

        //then
        assertThat(lottoNumber.toString().equals(num + ""));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 6, 7, 8, 33, 45})
    @DisplayName("숫자와 일치하는 번호를 가진 로또넘버 객체들은 동일하다.")
    void same_lotto_number_with_same_number(int num) {
        //given

        //when
        LottoNumber firstLottoNumber = LottoNumber.of(num);
        LottoNumber secondLottoNumber = LottoNumber.of(num);

        //then
        assertThat(firstLottoNumber.equals(secondLottoNumber));
        assertEquals(firstLottoNumber.hashCode(), secondLottoNumber.hashCode());
    }


    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, 46, 47})
    @DisplayName("범위 밖의 숫자는 로또넘버를 반환하지 않고 알맞은 예외를 발생시킨다.")
    void out_of_range_number_is_invalid(int num) {
        assertThatThrownBy(() -> LottoNumber.of(num))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining(OUT_OF_RANGE_EXCEPTION);
    }

}