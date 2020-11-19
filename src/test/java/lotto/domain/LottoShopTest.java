package lotto.domain;

import lotto.domain.exception.NotValidLottoPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoShopTest {

    private static final String NOT_VALID_PRICE_MESSAGE = "원 만큼 더 필요합니다";

    @DisplayName("로또 금액보다 더 낮은 금액으로 구매할 경우 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"800:200", "500:500", "150:850"}, delimiter = ':')
    public void notValidLottoPriceTest(int purchasePrice, int insufficientAmount) {

        assertThatThrownBy(() -> {
                        LottoShop shop = new LottoShop();
                        shop.purchase(purchasePrice, new LottoAutoMachine());
                })
                .isInstanceOf(NotValidLottoPriceException.class)
                .hasMessage(insufficientAmount + NOT_VALID_PRICE_MESSAGE);

    }

    @DisplayName("로또 구매 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "15000:15", "5000:5"}, delimiter = ':')
    public void purchaseLottoTest(int purchasePrice, int expected) {

        //Given & When
        LottoShop shop = new LottoShop();
        Lottos lottos = shop.purchase(purchasePrice, new LottoMachine() {
            @Override
            List<Integer> createLottoNumber() {
                return Arrays.asList(1, 3, 5, 8, 6);
            }
        });

        //Then
        assertThat(lottos.quantity()).isEqualTo(expected);

    }


}
