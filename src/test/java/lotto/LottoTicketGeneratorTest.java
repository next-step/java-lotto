package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.LottoTicketBall;
import lotto.domain.LottoTicketCollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketGeneratorTest {

    private LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(
        new LottoTicketBall());

    @Test
    public void 구입금액에_따른_로또_발급() {
        LottoTicketCollection lottoTicketCollection = lottoTicketGenerator.purchaseLotto(14000,
            List.of(List.of(1, 2, 3, 4, 5, 6)));
        assertThat(lottoTicketCollection.getAutoTickets().size()).isEqualTo(14);
        assertThat(lottoTicketCollection.getManualTickets().size()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, -1})
    public void 구입금액이_1000원_미만일_시_로또_발급_불가능(int input) {
        assertThatThrownBy(() -> lottoTicketGenerator.purchaseLotto(input,
            List.of(List.of(1, 2, 3, 4, 5, 6)))).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("로또를 구매할 수 없습니다.");
    }
}

