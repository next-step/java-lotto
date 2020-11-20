package lotto.domain;

import lotto.domain.exception.ErrorMessage;
import lotto.domain.exception.NotValidLottoPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPriceTest {

    @Test
    public void createLottoPriceInstanceTest() {
        //Given & When
        LottoPrice lottoPrice = new LottoPrice(1000);

        //Then
        assertThat(lottoPrice).isNotNull();
    }

    @DisplayName("로또 금액보다 더 낮은 금액으로 구매할 경우 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"800:200", "500:500", "150:850"}, delimiter = ':')
    public void notValidLottoPriceTest(int purchasePrice, int insufficientAmount) {
        assertThatThrownBy(() -> {

            LottoShop shop = new LottoShop();
            shop.purchase(new LottoPrice(purchasePrice), new LottoAutoMachine());
        }).isInstanceOf(NotValidLottoPriceException.class)
          .hasMessage(insufficientAmount + ErrorMessage.NOT_VALID_PRICE.getMessage());
    }
}
