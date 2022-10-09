package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    @Test
    @DisplayName("로또 개수만큼 발급할 수 있다.")
    void create() {
        LottoTickets lottoTickets = LottoTickets.from(14000);
        assertThat(lottoTickets.countTicket()).isEqualTo(14);
    }

    @Test
    @DisplayName("1000원 미만은 로또를 구매할 수 없다.")
    void valid() {
        assertThatThrownBy(() -> LottoTickets.from(500))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개를 맞추면 1등을 하는 결과가 나온다.")
    void result() {
        List<LottoNumber> list = new ArrayList<>(
            List.of(LottoNumber.from(1), LottoNumber.from(2),
                LottoNumber.from(3), LottoNumber.from(4), LottoNumber.from(5),
                LottoNumber.from(6)));
        LottoTickets lottoTickets = LottoTickets.from(2000, LottoNumbers.of(list));

        LottoResult result = lottoTickets.result(LottoNumbers.of(list));
        assertThat(result.count(Rank.FIRST)).isEqualTo(1);
    }
}
