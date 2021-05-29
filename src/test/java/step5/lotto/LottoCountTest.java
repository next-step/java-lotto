package step5.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoCountTest {
    @DisplayName("1000원 이하의 돈 입력시 예외처리")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "100", "1"})
    void inputPriceException(int price) {
        assertThatThrownBy(() -> {
            new LottoCount(price, 3);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("로또는 1000원 이상부터 구매할수있습니다.");
    }

    @DisplayName("입력한 금액만큼 로또 개수 계산되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "14000:14", "7000:7"}, delimiter = ':')
    void calculateInputPrice(int price, int expected) {
        LottoCount lottoCount = new LottoCount(price, 0);
        int result = lottoCount.calculatePriceToCount(price);
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("로또 개수를 금액으로 변환")
    @ParameterizedTest
    @CsvSource(value = {"14000:14000", "1000:1000", "7000:7000"}, delimiter = ':')
    void calculateInputCountToPrice(int price, int expected) {
        LottoCount lottoCount = new LottoCount(price, 3);
        int result = lottoCount.calculateCountToPrice();
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("수동구매 개수 범위 초과시 예외 확인")
    @ParameterizedTest
    @CsvSource(value = {"14000:15", "1000:3", "7000:10"}, delimiter = ':')
    void validManualCount(int price, int manualCount) {
        assertThatThrownBy(() -> {
            new LottoCount(price, manualCount);
        }).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("수동으로 구매 가능한 개수가 아닙니다.");
    }

    @DisplayName("수동구매 개수가 0개인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"14000:3:false", "1000:0:true", "7000:5:false"}, delimiter = ':')
    void checkManualCount(int price, int manualCount, boolean result) {
        LottoCount lottoCount = new LottoCount(price, manualCount);
        assertThat(lottoCount.isLottoManualCountZero()).isEqualTo(result);
    }

    @DisplayName("자동 구매개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"14000:3:11", "1000:0:1", "7000:5:2"}, delimiter = ':')
    void autoLottoCount(int price, int manualCount, int autoCount) {
        LottoCount lottoCount = new LottoCount(price, manualCount);
        assertThat(lottoCount.autoLottoCount()).isEqualTo(autoCount);
    }
}