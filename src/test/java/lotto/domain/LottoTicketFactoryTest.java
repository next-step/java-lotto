package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketFactoryTest {

    @DisplayName("돈을 인자로 전달하면 LottoTickets를 살 수 있다. LottoTicket은 한 개에 1000원이다")
    @ParameterizedTest
    @CsvSource(value = {"140000:140", "14300:14", "990:0"}, delimiter = ':')
    void buy(int money, int numberOfTicket) {
        LottoTickets lottoTickets = LottoTicketFactory.buy(money);
        assertThat(lottoTickets.size()).isEqualTo(numberOfTicket);
    }

    @DisplayName("구입할 금액은 숫자를 입력해야한다. ")
    @Test
    void buyWithMoneyValidation() {
        assertThatThrownBy(() -> LottoTicketFactory.buy("string"))
                .isInstanceOf(LottoException.class);
    }

    @DisplayName("1에서 45사이 숫자 6개를 랜덤으로 만들어낸다.")
    @Test
    void generate() {
        LottoTickets lottoTickets = LottoTicketFactory.buy(1000);
        LottoTicket lottoTicket = lottoTickets.getLottoTickets().get(0);
        List<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        lottoNumbers.forEach(lottoNumber ->
                assertThat(lottoNumber.getNumber()).isBetween(1, 45)
        );
        assertThat(lottoNumbers.size()).isEqualTo(6);
    }


}