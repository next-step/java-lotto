package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTest {

    @DisplayName("구입 할 수 있는 로또의 개수를 구한다")
    @ParameterizedTest
    @CsvSource(value = {"10000,10","15000,15","1000,1"})
    public void buyLottos(int price, int expected) throws Exception {
        //when
        Lotto lotto = new Lotto();
        int purchaseQuantity = lotto.purchaseQuantity(price);

        //then
        assertEquals(expected, purchaseQuantity);
    }

    @Test
    @DisplayName("1000원 미만의 금액으로 로또를 구매하려고 하면 오류")
    public void purchasePriceLimit() {
        //given
        int price = 900;

        //when
        Lotto lotto = new Lotto();

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lotto.purchaseQuantity(price))
                .withMessageMatching("1000원 이상의 금액을 입력해야합니다.");
    }
}
