package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoNumberTest {

    static IntStream createLotto() {
        return IntStream.range(1, 46);
    }

    static IntStream createLottoFail() {
        return IntStream.of(-1, 0, -50, 46, 500);
    }

    @ParameterizedTest
    @DisplayName("로또 넘버는 범위는 1부터 45여야한다.")
    @MethodSource("createLotto")
    void 로또_숫자_1_45(int number) {
        // when
        LottoNumber lottoNumber = new LottoNumber(number);

        // then
        assertThat(lottoNumber.getNumber()).isBetween(1, 45);
    }


    @ParameterizedTest
    @DisplayName("로또 넘버가 1보다 작거나 45보다 큰 경우 예외가 발생한다.")
    @MethodSource("createLottoFail")
    void 로또_숫자_범위_벗어난_경우(int number) {
        // when , then
        assertThatCode(() -> new LottoNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45까지 이어야합니다.");
    }


    @Test
    @DisplayName("로또 번호가 같으면 같은 객체이다")
    void 로또_번호_같으면_같은_객체() {
        // given
        LottoNumber firstLottoNumber = new LottoNumber(1);
        LottoNumber secondLottoNumber = new LottoNumber(1);

        // when , then
        assertThat(firstLottoNumber).isEqualTo(secondLottoNumber);
    }


    @Test
    @DisplayName("로또 번호가 같으면 다른 객체이다")
    void 로또_번호_같으면_다른_객체() {
        // given
        LottoNumber firstLottoNumber = new LottoNumber(1);
        LottoNumber secondLottoNumber = new LottoNumber(2);

        // when , then
        assertThat(firstLottoNumber).isNotEqualTo(secondLottoNumber);
    }
}
