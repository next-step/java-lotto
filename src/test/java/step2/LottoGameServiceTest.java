package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.dto.Ticket;
import step2.service.LottoGameService;


import static org.assertj.core.api.Assertions.assertThat;

class LottoGameServiceTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2", "4,4", "6,6"})
    @DisplayName("티켓을 넘기면 갯수만큼 생성된 티켓 묶음이 반환된다")
    public void shuffleLotto(int input, int expected) {
        assertThat(new LottoGameService().shuffleLotto(new Ticket(input)).lottoTicketsCount())
                .isEqualTo(expected);
    }
}
