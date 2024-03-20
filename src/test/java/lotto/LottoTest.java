package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("겹치지 않는 로또 번호 6개를 가질 수 있다.")
    @Test
    void create() {
        Lotto lotto = Lotto.create(() -> List.of(5, 6, 7, 8, 9, 10));
        assertThat(lotto.numbers()).containsExactly(new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7),
                new LottoNumber(8),
                new LottoNumber(9),
                new LottoNumber(10));
    }

    @DisplayName("로또 사이즈와 맞지 않을 경우 예외를 던진다.")
    @Test
    void createThrowError() {
        assertThatThrownBy(() -> Lotto.create(() -> List.of(5, 6, 7, 8, 9)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("몇개의 로또번호가 맞는지 확인할 수 있다.")
    @Test
    void getCountMatchedLottoNumber() {
        Lotto prizeLotto = Lotto.create(() -> List.of(1, 2, 3, 4, 5, 6));
        Lotto targetLotto = Lotto.create(() -> List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThat(targetLotto.getCountMatchedLottoNumber(prizeLotto)).isEqualTo(6);
    }
}
