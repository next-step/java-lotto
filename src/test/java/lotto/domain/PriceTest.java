package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Price 객체의 기능 테스트
 */
public class PriceTest {

    @ParameterizedTest
    @CsvSource(value = {"3000,3,true", "2000,3,false"})
    @DisplayName("구입금액으로 희망 구매 수량 여부 확인")
    void canBuy(int price, int manualCount, boolean result) {
        // given
        Price buyPrice = new Price(price);

        //then
        assertThat(buyPrice.canBuy(manualCount)).isEqualTo(result);
    }

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
