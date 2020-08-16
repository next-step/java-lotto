package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoMoneyTest {

    @Test
    @DisplayName("로또 구입 금액이 1000원 이하면 예외를 발생시킨다")
    void newMoneyTest() {
        assertThatThrownBy(() -> new LottoMoney(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

}