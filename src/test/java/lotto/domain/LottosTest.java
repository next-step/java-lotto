package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @DisplayName("로또가격은 1000원, 가지고 있는 금액만큼 로또를 구입한다")
    @Test
    void 금액만큼_로또구입() {
        Lottos lottos = new Lottos(10000);
        assertThat(lottos.numberOfLotto()).isEqualTo(10);
    }

    @DisplayName("로또가격보다 적은 구입금액 입력시 예외")
    @Test
    void 잔액부족() {
        assertThatThrownBy(() -> new Lottos(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잔액이 부족합니다.");
    }
}
