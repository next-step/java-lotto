package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoTest {
    private LottoNumber lottoNumber;
    private LottoCreator lottoCreator;
    private LottoTicket lottoTicket;
    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        lottoCreator = new LottoCreator();
        lottoTicket = lottoCreator.makeLottoTicket();
        lottoTickets = lottoCreator.makeLottoTickets(5);
    }

    @DisplayName("로또 번호는 1~45로 구성되어있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void validateLottoNumberTest(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoNumber = new LottoNumber(number);
        });
    }

    @DisplayName("로또는 6개의 서로다른 정수로 구성되어있다.")
    @Test
    void makeLottoTicketTest() {
        assertThat(lottoTicket.lottoTicketSize()).isEqualTo(6);
    }

    @DisplayName("로또티켓은 여러장 일 수 있다.")
    @Test
    void makeLottoTicketsTest() {
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(5);
    }
}
