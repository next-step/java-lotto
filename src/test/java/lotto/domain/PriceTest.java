package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PriceTest {

    @ParameterizedTest
    @ValueSource(longs = {1999L, 1099L, 1009L})
    @DisplayName("구입 금액 나머지 검증")
    void validate_remainderPrice(Long inputPrice) {
        assertThatThrownBy(() -> new Price(inputPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 1,000원 단위로만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(longs = {999L, 99L, 9L})
    @DisplayName("최소금액 입력 검증")
    void validate_minimum_price(Long inputPrice) {
        assertThatThrownBy(() -> new Price(inputPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 금액은 1,000원 입니다.");
    }

    @ParameterizedTest
    @ValueSource(longs = {1000L, 2000L, 10000L, 10000000000L})
    @DisplayName("가격 객체 생성")
    void create(Long inputPrice) {
        Price price = new Price(inputPrice);
        assertThat(price.getPrice()).isEqualTo(inputPrice);
    }
}
