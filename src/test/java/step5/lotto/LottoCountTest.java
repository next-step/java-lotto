package step5.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoCountTest {
    private LottoCount lottoCount;
    @BeforeEach
    void setUp() {
        lottoCount = new LottoCount(14000);
    }

    @DisplayName("1000원 이하의 돈 입력시 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "100", "1"})
    void inputPriceException(int price) {
        assertThatThrownBy(() -> {
            new LottoCount(price);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("로또는 1000원 이상부터 구매할수있습니다.");
    }

    @DisplayName("입력한 금액만큼 로또 개수 계산되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14", "7000:7"}, delimiter = ':')
    void calculateInputPrice(int price, int expected) {
        int result = lottoCount.calculatePriceToCount(price);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("로또 개수를 금액으로 변환")
    @ParameterizedTest
    @CsvSource(value = {"14000:14000", "1000:1000", "7000:7000"}, delimiter = ':')
    void calculateInputCountToPrice(int price, int expected) {
        LottoCount lottoCount = new LottoCount(price);
        int result = lottoCount.calculateCountToPrice();
        assertThat(result).isEqualTo(expected);
    }
}