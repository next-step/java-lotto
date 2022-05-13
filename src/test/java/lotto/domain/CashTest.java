package lotto.domain;

import lotto.exception.InvalidCash;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CashTest {

    @Test
    @DisplayName("15000원 입력 시 구매할 총 로또 개수는 15개이다.")
    void totalLottoCount() {
        assertThat(new Cash(15000).totalLottoCount()).isEqualTo(15);
    }

    @Test
    @DisplayName("로또 가격보다 작을 경우 InvalidCash 를 반환한다.")
    void invalidCash() {
        assertThatThrownBy(() -> new Cash(500))
                .isInstanceOf(InvalidCash.class)
                .hasMessage("1000원 이상이여야 합니다.");
    }

}