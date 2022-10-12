package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @ParameterizedTest
    @DisplayName("생성자 금액 검증 - 최소금액(천원), 최대 금액(십만원)")
    @ValueSource(ints = {500, 100500})
    void constructorDI(int amount) {
        assertThatThrownBy(() -> new Lotto(amount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 발급 수 검증")
    void issueLotto() {
        assertThat(new Lotto(10000).tickets().size()).isEqualTo(10);
    }

    @Test
    @DisplayName("구매 금액 검증")
    void paymentAmount() {
        assertThat(new Lotto(10000).payment()).isEqualTo(10000);
    }
}
