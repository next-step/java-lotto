package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketGeneratorTest {

    @Test
    @DisplayName("로또 티켓 생성 테스트")
    void generateLottoTicket() {
        LottoTicket lottoTicket = new LottoTicketGenerator().generate();

        // 생성된 lottoTicket은 NULL이 될 수 없다.
        assertThat(lottoTicket).isNotNull();

        // LottoNumber는 중복 될 수 없다.
        LottoNumber[] lottoNumbers = lottoTicket.toArray();
        Arrays.sort(lottoNumbers);
        LottoNumber prevLottoNumber = null;
        for(LottoNumber lottoNumber : lottoNumbers) {
            assertThat(lottoNumber).isNotEqualTo(prevLottoNumber);
            prevLottoNumber = lottoNumber;
        }
    }
}
