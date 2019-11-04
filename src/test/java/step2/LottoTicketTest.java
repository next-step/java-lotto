package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoTicket;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    LottoTicket lottoTicket = new LottoTicket();
    List<Integer> lottoNumbers = lottoTicket.makeAutoNumbers();

    int sizeOfLottoNumbers = lottoNumbers.size();

    @DisplayName("로또 숫자 6개 생성")
    @Test
    void makeAutoNumbersTest() {
        assertThat(sizeOfLottoNumbers).isEqualTo(6);
    }

    @DisplayName("1~45 인지 검사")
    @Test
    void checkRangeTest() {
        assertThat(lottoNumbers).allSatisfy(elem -> assertThat(elem).isBetween(1, 45));
    }

}
