package lotto.domain.lotto;

import org.junit.jupiter.api.DisplayName;
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
}
