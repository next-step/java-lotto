package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.exception.NotDivideZeroException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameMoneyTest {

    @Test
    @DisplayName("로또게임머니가 잘 생성되는지 확인한다.")
    void create() {
        assertThat(new GameMoney(1000)).isEqualTo(new GameMoney(1000));
    }

    @Test
    @DisplayName("게임머니가 잘 쌓이는지 확인한다.")
    void sum() {
        assertThat(new GameMoney(1000).sum(new GameMoney(1000))).isEqualTo(new GameMoney(2000));
    }
    @Test
    @DisplayName("투자대비 수익이 잘 나오는지 확인한다.")
    void splitRate() {
        assertThat(new GameMoney(10000).splitRate(new GameMoney(1000))).isEqualTo(10);
    }

    @Test
    @DisplayName("0으로 나눌때 익셉션이 발생하는지 확인한다.")
    void splitRateZeroException() {
        assertThatThrownBy(() -> new GameMoney(10000).splitRate(new GameMoney(0)))
                .isInstanceOf(NotDivideZeroException.class);
    }
}