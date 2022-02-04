package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    void 입력받은_개수의_로또_생성(int lottoCount) {
        LottoTicket lottoTicket = new LottoTicket(lottoCount);
        assertThat(lottoTicket.lottoCount()).isEqualTo(lottoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void 로또_티켓은_1개_이상일_때만_생성할_수_있다(int lottoCount) {
        assertThatThrownBy(() -> new LottoTicket(lottoCount))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
