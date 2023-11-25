package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.Price;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static step4.model.Price.EACH_LOTTO_PRICE;

public class PriceTest {

    @ParameterizedTest
    @ValueSource(ints = {12450, 35400, 2140, 1240, 6500, 98123, -1000, -24340})
    @DisplayName("지불한 가격이 0으로 떨어지지 않거나 음수로 나올 경우 예외를 발생시킨다.")
    void inValidPayPriceTest(int lottoPayPrice) {
        assertThatThrownBy(() -> new Price(lottoPayPrice).lottoCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액을 잘못 입력 하였습니다. 로또 한장의 가격은 " + EACH_LOTTO_PRICE + "원 입니다.");
    }
}
