import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.LottoService;
import lotto.LottoTicket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoServiceTest {

    private LottoService lottoService = new LottoService();

    @Test
    public void 구입금액에_따른_로또_발급() {
        assertThat(lottoService.purchaseLotto(14000).size()).isEqualTo(14);
    }

    @ParameterizedTest
    @ValueSource(ints = {999, -1})
    public void 구입금액이_1000원_미만일_시_로또_발급_불가능(int input) {
        assertThatThrownBy(() -> lottoService.purchaseLotto(input)).isInstanceOf(
                IllegalArgumentException.class).hasMessageContaining("로또를 구매할 수 없습니다.");
    }

    @Test
    public void 당첨_결과_조회() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(LottoTicket.createTicket(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))));
        tickets.add(LottoTicket.createTicket(new ArrayList<>(List.of(13, 18, 23, 28, 34, 42))));
        List<Integer> winningNumbers = List.of(1, 13, 18, 23, 28, 34);
        assertThat(lottoService.checkWinningResult(tickets, winningNumbers)).isEqualTo(List.of(0,1,0,0,0,1,0));
    }
}

