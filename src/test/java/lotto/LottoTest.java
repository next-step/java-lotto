package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void determinePrize() {
        // given
        Lotto lotto = Lotto.from(List.of(1, 2, 3, 4, 5, 45));

        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusBall = LottoNumber.from(45);


        // when
        Rank rank = lotto.determinePrize(winningLotto, bonusBall);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
