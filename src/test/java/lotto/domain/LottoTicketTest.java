package lotto.domain;

import lotto.domain.exception.NotValidLottoTicketException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @DisplayName("구매비용에 따른 로또 교환권 발급 테스트")
    @ParameterizedTest
    @CsvSource(value = {"15000:15", "13000:13", "1000:1"}, delimiter = ':')
    public void createLottoTicketInstanceTest(int purchasePrice, int expected) {

        //Given & When
        LottoTicket lottoTicket = LottoShop.purchase(purchasePrice);

        //Then
        assertThat(lottoTicket).isNotNull();
        assertThat(lottoTicket.getTicketQuantity()).isEqualTo(expected);

    }

    @DisplayName("LottoTicket 0개일 경우 예외 테스트")
    @Test
    public void notValidLottoTicketExceptionTest(){
        assertThatThrownBy(() -> new LottoTicket(0))
                .isInstanceOf(NotValidLottoTicketException.class)
                .hasMessage("로또 티켓은 1개 이상이어야 합니다");
    }
}
