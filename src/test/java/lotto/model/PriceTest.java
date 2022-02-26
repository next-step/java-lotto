package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceTest {

    @DisplayName("1000원 이하의 금액은 입력될 수 없다")
    @Test
    void validatePrice() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
            () -> new Price(500));
    }

    @DisplayName("금액에 따라 구입가능한 모든 로또개수를 계산한다")
    @Test
    void calculateTotalCount() {
        Price price = new Price(5000);
        int totalLottoCount = price.calculateTotalCount();
        assertThat(totalLottoCount).isEqualTo(5);
    }
}
