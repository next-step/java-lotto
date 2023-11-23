package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import org.junit.jupiter.api.Test;

public class LottoTest {
    Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

    @Test
    void determinePrize() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 40, 41));

        // when
        Prize prize = lotto.determinePrize(winningLotto);

        // then
        assertThat(prize).isEqualTo(Prize.FOUR_MATCHING);
    }
}
