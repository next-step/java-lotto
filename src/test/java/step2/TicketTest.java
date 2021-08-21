package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTest {

    @Test
    @DisplayName("로또 번호를 저장한다.")
    void lottoTicket_save() {
        Ticket lottoTicket = new Ticket();

        // 로또 번호 생성
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);

        lottoTicket.saveLottoNumbers(lottoNumbers);
        List<Integer> getLottoNumbers = lottoTicket.getLottoNumbers();

        assertThat(getLottoNumbers).isEqualTo(lottoNumbers);
    }
}
