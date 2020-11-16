package lotto.domain;

import lotto.domain.exception.NotValidLottoPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoShopTest {

    @DisplayName("로또 금액보다 더 낮은 금액으로 구매할 경우 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"800:200", "500:500", "150:850"}, delimiter = ':')
    public void notValidLottoPriceTest(int purchasePrice, int insufficientAmount) {

        assertThatThrownBy(() -> LottoShop.purchase(purchasePrice))
                .isInstanceOf(NotValidLottoPriceException.class)
                .hasMessage(insufficientAmount + "원 만큼 더 필요합니다");

    }

    @DisplayName("로또 구매금엑에 따른 로또 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "15000:15", "5000:5"}, delimiter = ':')
    public void exchangeToLottosTest(int purchasePrice, int expected) {

        //Given
        LottoTicket ticket = LottoShop.purchase(purchasePrice);

        //When
        Lottos lottos = LottoShop.exchangeToLotto(ticket, new LottoAutoMachine());

        //Then
        assertThat(lottos.hasLottoSize()).isEqualTo(expected);

    }




}
