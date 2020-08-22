package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.model.LottoTicket;

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
        assertThat(lotto.numbers()).contains("4", "12", "32", "25", "11", "22");
    }

    @Test
    @DisplayName("input string에서 6개의 숫자를 입력받았는지 체크")
    public void inputString_checkTheSizeOfInputis6() {
        String value = "[1, 2, 3, 4, 5]";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lotto = new LottoTicket(value));
    }

    @Test
    @DisplayName("input String에서 lottoNumber 크기를 벗어난 숫자가 오는지 체크")
    public void inputString_checkTheMaximumAndMinimumValue_Of_Input() {
        String value = "[4, 56, 32, 25, 11, 22]";
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> lotto = new LottoTicket(value));
    }

    @Test
    @DisplayName("입력된 값으로 생성된 티켓 중, 정답값 들어왔을 때 몇 개 일치하는지 확인")
    public void check_inputString_and_HowManyNumbers_hit_between_input_and_expected() {
        String value = "[4, 12, 32, 25, 11, 22]";
        lotto = new LottoTicket(value);
        String[] expected = {"4", "13", "15", "22", "13", "5"};
        assertThat(lotto.matchedNumber(expected)).isEqualTo(2);
    }
}
