package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 티켓 생성 테스트")
class LottoGeneratorTest {

    @DisplayName("로또 티켓은 6개의 숫자로 생성된다")
    @Test
    void lottoGenerate_basic() {
        LottoTicket lottoTicket = LottoGenerator.generateLottoNumbers();

        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }

    @ParameterizedTest(name = "로또 티켓은 원하는 수량만큼 생성할수 있다")
    @ValueSource(ints = {1, 10, 100})
    void lottoGenerate_with_count(int numberOfLottoTickets) {
        LottoTickets lottoTickets = LottoGenerator.generateLottoTickets(numberOfLottoTickets);

        assertThat(lottoTickets.findLottoTicketCount()).isEqualTo(numberOfLottoTickets);
    }
}
