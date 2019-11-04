package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class IssuedLottosTest {

    @Test
    void 발급된_로또_당첨_확인() {
        IssuedLottos issuedLottos = new IssuedLottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 2, 3, 40, 41, 42)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 40, 41)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 40)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                        new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15))
                )
        );

        WinningStatus winningStatus = issuedLottos.checkRank(Arrays.asList(1, 2, 3, 4, 30, 31), 40);
        assertThat(winningStatus.getCountOfRankFor(Rank.SECOND)).isEqualTo(1);
    }
}
