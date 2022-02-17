package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceTest {

    @DisplayName("1000원 이하의 금액은 입력될 수 없다")
    @Test
    void validatePrice(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
            () -> new Price(500));
    }

    @Test
    void 금액에_따라_구입가능한_모든_로또개수를_계산한다() {
        Price price = new Price(5000);
        int totalLottoCount=price.calculateTotalCount();
        assertThat(totalLottoCount).isEqualTo(5);
    }
}