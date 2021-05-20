package lotto.domain.ticket;

import lotto.domain.PositiveInteger;
import lotto.domain.generator.LottoNumberRandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTicketsTest {
    @Test
    @DisplayName("갯수와 제너레이터를 입력받아 갯수만큼 만들 수 있다.")
    public void 갯수와_제너레이터를_입력받아_갯수만큼_만들_수_있다() {
        int size = 5;

        LottoTickets lottoTickets = LottoTickets.createByGenerator(new LottoNumberRandomGenerator(), new PositiveInteger(size));

        assertThat(lottoTickets.size())
                .isEqualTo(size);
    }

    @Test
    @DisplayName("갯수가 음수이면 IllegalArgumentException이 발생한다")
    public void 갯수가_음수이면_IllegalArgumentException이_발생한다() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTickets.createByGenerator(new LottoNumberRandomGenerator(), new PositiveInteger(-1)));
    }
}
