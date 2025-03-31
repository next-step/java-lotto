package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoTest {
    @Test
    @DisplayName("빈 번호로 생성할 수 없다.")
    void lotto() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호가 6개가 아니면 예외가 발생한다.")
    void lotto_1() {
        Assertions.assertThatThrownBy(() -> new Lotto(
                List.of(LottoNumber.valueOf(1),
                        LottoNumber.valueOf(2),
                        LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4),
                        LottoNumber.valueOf(5))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 번호가 있으면 예외가 발생한다.")
    void lotto_2() {
        Assertions.assertThatThrownBy(() -> new Lotto(
                List.of(LottoNumber.valueOf(1),
                        LottoNumber.valueOf(2),
                        LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4),
                        LottoNumber.valueOf(5),
                        LottoNumber.valueOf(1))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("번호가 1~45 사이의 숫자가 아니면 예외가 발생한다.")
    void lotto_3() {
        Assertions.assertThatThrownBy(() -> new Lotto(
                List.of(LottoNumber.valueOf(1),
                        LottoNumber.valueOf(2),
                        LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4),
                        LottoNumber.valueOf(5),
                        LottoNumber.valueOf(46))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("서로 다른 6개의 로또 번호가 제공된 경우 정상적으로 생성된다.")
    void lotto_4() {
        Lotto lotto = new Lotto(
                List.of(LottoNumber.valueOf(1),
                        LottoNumber.valueOf(2),
                        LottoNumber.valueOf(3),
                        LottoNumber.valueOf(4),
                        LottoNumber.valueOf(5),
                        LottoNumber.valueOf(6)));
        Assertions.assertThat(lotto).isNotNull();
    }
}
