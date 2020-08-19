package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력받는 로또 티켓에 대한 테스트 먼저 작성")
public class LottoTicketTest {

    @Test
    public void inputString_parsingTest() {
        String value = "[4, 12, 32, 25, 11, 22]";
        value = value.replaceAll("[\\[\\] ]","");
        String[] lottoNumber = value.split(",");
        assertThat(lottoNumber).contains("4","12","32","25","11","22");
    }
}
