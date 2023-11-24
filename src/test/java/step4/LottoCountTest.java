package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.LottoCount;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCountTest {

    @ParameterizedTest
    @CsvSource(value = {"3,10","4,10","1,5","5,6","6,25"}, delimiter = ',')
    @DisplayName("수동 로또 갯수를 잘못 입력했을 경우 예외가 발생한다.")
    void invalidManualLottoCountTest(int allLottoCount, int manualLottoCount) {
        assertThatThrownBy(() -> new LottoCount().autoLottoCount(allLottoCount, manualLottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지불한 금액보다 로또 수량이 더 많습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -5, -7, -25, -1})
    @DisplayName("수동 로또 갯수를 음수로 입력했을 경우 예외가 발생한다.")
    void manualLottoCountNegativeTest(int manualLottoCount) {
        assertThatThrownBy(() -> new LottoCount().isPositive(manualLottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }
}
