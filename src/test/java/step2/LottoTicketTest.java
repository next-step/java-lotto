package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("입력받는 로또 티켓에 대한 테스트 먼저 작성")
public class LottoTicketTest {
    private LottoTicket lotto;
    @Test
    @DisplayName("로또 입력을 받은 다음 정상적으로 티켓에 입력됐는지 확인.")
    public void inputString_parsingTest() {
        String value = "[4, 12, 32, 25, 11, 22]";
        lotto = new LottoTicket(value);
        assertThat(lotto.numbers()).contains("4","12","32","25","11","22");
    }

    @Test
    @DisplayName("input string에서 6개의 숫자를 입력받았는지 체크")
    public void inputString_checkTheSizeOfInputis6() {
        String value = "[1, 2, 3, 4, 5]";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lotto = new LottoTicket(value));
    }
}
