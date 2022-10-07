package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {

    @DisplayName("정렬되지 않은 로또 번호로 로또를 생성하면, 정렬된 번호의 로또가 생성되어야 한다.")
    @Test
    void create_withUnsortedNumbers() {
        assertThat(new Lotto(List.of(
                new LottoNumber(3),
                new LottoNumber(2),
                new LottoNumber(1),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ))).isEqualTo(new Lotto(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        )));
    }

    @DisplayName("중복된 로또 번호로 로또를 생성하면, 예외가 발생해야 한다.")
    @Test
    void create_givenDuplicatedNumbers() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(
                        new LottoNumber(1),
                        new LottoNumber(1),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                )));
    }

    @DisplayName("충분하지 않은 개수의 로또 번호로 로또를 생성하면, 예외가 발생해야 한다.")
    @Test
    void create_givenNotEnoughSizeOfNumbers() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(List.of(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5)
                )));
    }

}
