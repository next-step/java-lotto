package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.LottoNumbers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("45자리 로또 번호 클래스 테스트")
class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호가 1부터 45까지 존재하는지 확인하는 테스트")
    void lottoNumbersTest() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<Integer> numbers = lottoNumbers.getNumbers();
        for (int i = 1; i <= 45; i++) {
            assertThat(i).isEqualTo(numbers.get(i - 1));
        }
    }

    @Test
    @DisplayName("로또 번호 6개씩 count만큼 나오는지 테스트")
    void extractLottoTicketsByCountTest() {
        int lottoCount = 3;
        int lottoNumberCount = 6;
        LottoNumbers lottoNumbers = new LottoNumbers();
        List<LottoTicket> lottoTickets = lottoNumbers.extractLottoTicketsByCount(3);
        assertThat(lottoTickets).hasSize(lottoCount);
        lottoTickets.forEach(lottoTicket -> assertThat(lottoTicket.getNumbers()).hasSize(lottoNumberCount));
    }
}