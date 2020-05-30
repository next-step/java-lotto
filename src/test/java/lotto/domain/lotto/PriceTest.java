package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("Price 클래스 테스트")
public class PriceTest {

    @DisplayName("Price 객체를 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    void createPrice(int price) {
        assertThatCode(() -> new Price(price)).doesNotThrowAnyException();
        assertThat(new Price(price).getPrice()).isEqualTo(price);
    }

    @DisplayName("로또 구매 갯수를 반환할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    void getLottoCount(int price) {
        Price newPrice = new Price(price);
        assertThat(newPrice.getLottoCount()).isEqualTo(newPrice.getPrice()/Price.LOTTO_PRICE);
    }

    @DisplayName("수익률을 계산할 수 있다.")
    @Test
    void calculateProfitRate() {
        Price price = new Price(10000);
        int rankSum = 10000;

        float profitRate = price.calculateProfitRate(rankSum);
        assertThat(profitRate).isEqualTo((float)rankSum/price.getPrice());
    }
}
