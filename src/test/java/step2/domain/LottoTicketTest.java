package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.LottoTicket;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTicketTest {

    @Test
    public void createTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoTicket("1,2,3,4,5,6,7");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new LottoTicket("1,2,3,4,5");
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:1,2,3,4,5,6:6", "1,2,3,4,5,6:1,2,3,4,5,7:5", "1,2,3,4,5,6:1,2,3,4,7,8:4", "1,2,3,4,5,6:1,2,3,7,8,9:3", "1,2,3,4,5,6:1,2,7,8,9,10:2", "1,2,3,4,5,6:1,11,7,8,9,10:1", "1,2,3,4,5,6:12,11,7,8,9,10:0"}, delimiter = ':')
    public void winningCountTest(String lottoInput, String winningInput, int expected) {
        LottoTicket lottoTicket = new LottoTicket(lottoInput);
        LottoTicket winningTicket = new LottoTicket(winningInput);
        Assertions.assertThat(lottoTicket.winningCount(winningTicket)).isEqualTo(expected);
    }
}