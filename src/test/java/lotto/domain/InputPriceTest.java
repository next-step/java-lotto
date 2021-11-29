package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.utils.Constants.NUMBER_THOUSAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputPriceTest {
    @Test
    @DisplayName("InputPrice 생성자 테스트")
    public void constructor() {
        assertThat(new InputPrice(NUMBER_THOUSAND)).isEqualTo(new InputPrice(NUMBER_THOUSAND));
    }

    @Test
    @DisplayName("입력받은 금액이 1000원 단위인지 체크한다.")
    void validateSmallestUnit() {
        assertThatThrownBy(() -> {
            new InputPrice(999);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또는 1000원 단위로 구매할 수 있습니다.");
    }

    @Test
    @DisplayName("입력받은 금액을 1000원 단위로 나눈다")
    void divideByThousands() {
        assertThat(new InputPrice(10000).divideByThousands()).isEqualTo(10);
    }
}
