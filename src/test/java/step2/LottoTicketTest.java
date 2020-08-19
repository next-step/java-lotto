package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력받는 로또 티켓에 대한 테스트 먼저 작성")
public class LottoTicketTest {

    @Test
    @DisplayName("로또 입력을 받은 다음 정상적으로 티켓에 입력됐는지 확인.")
    public void inputString_parsingTest() {
        String value = "[4, 12, 32, 25, 11, 22]";
        LottoTicket lotto = new LottoTicket(value);
        assertThat(lotto.numbers()).contains("4","12","32","25","11","22");
    }
}
