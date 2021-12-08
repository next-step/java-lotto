package step2.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Money;
import sun.reflect.Reflection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "2000,2", "4000,4", "6000,6"})
    @DisplayName("로또 기본 금액 이상을 인자로 넘기면 갯수만큼 생성된 티켓 묶음이 반환된다")
    public void generateLotto(int input, int expected) {
        assertThat(LottoGame.generateLotto(new Money(input)).lottoTicketsCount())
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 300, 700, 900, 990})
    @DisplayName("로또 기본 금액 미만의 금액을 인자로 넘기면 예외를 던진다")
    public void generateLotto(int input) {
        assertThatThrownBy(() -> {
            LottoGame.generateLotto(new Money(input));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
