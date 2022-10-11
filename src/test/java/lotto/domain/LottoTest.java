package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 생성")
    @Test
    void create() {
        List<LottoNumber> numbers = List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));

        Lotto lotto = new Lotto(numbers);

        assertThat(lotto).isEqualTo(new Lotto(
                List.of(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6))));
    }

    @DisplayName("로또 생성 실패 - 로또 숫자 개수 미달")
    @Test
    void invalidSize() {
        assertThatThrownBy(() -> new Lotto(
                List.of(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6");
    }

    @DisplayName("로또 생성 실패 - 로또 숫자 중복")
    @Test
    void duplicatedNumbers() {
        assertThatThrownBy(() -> new Lotto(
                List.of(new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }


//    @ParameterizedTest
//    @CsvSource(value = {"1,2,3,4,5,6 6", "1,2,3,4,5,5"}, delimiterString = " ")
//    void howToMatch() {
//
//    }
}
