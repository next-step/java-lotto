package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step4.utils.CalculateUtils.*;

public class CalculateUtilsTest {


    @ParameterizedTest
    @ValueSource(ints = {12450, 35400, 2140, 1240, 6500, 98123, -1000, -24340})
    @DisplayName("지불한 가격이 0으로 떨어지지 않거나 음수로 나올 경우 예외를 발생시킨다.")
    void inValidPayPriceTest(int lottoPayPrice) {
        assertThatThrownBy(() -> lottoCount(lottoPayPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액을 잘못 입력 하였습니다. 로또 한장의 가격은 " + EACH_LOTTO_PRICE + "원 입니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"3,10","4,10","1,5","5,6","6,25"}, delimiter = ',')
    @DisplayName("수동 로또 갯수를 잘못 입력했을 경우 예외가 발생한다.")
    void invalidManualLottoCountTest(int allLottoCount, int manualLottoCount) {
        assertThatThrownBy(() -> autoLottoCount(allLottoCount, manualLottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지불한 금액보다 로또 수량이 더 많습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -5, -7, -25, -1})
    @DisplayName("수동 로또 갯수를 음수로 입력했을 경우 예외가 발생한다.")
    void manualLottoCountNegativeTest(int manualLottoCount) {
        assertThatThrownBy(() -> isPositive(manualLottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }
}
