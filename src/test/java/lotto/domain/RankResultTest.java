package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankResultTest {

    private static final int total = 200000000;

    @DisplayName("로또_등수를_합친_상금_테스트")
    @Test
    void totalPrizeTest() {

        Lotto lotto = new Lotto(
            Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream().map(LottoNumber::new)
                .collect(Collectors.toList()));
        Lottos lottos = new Lottos(Arrays.asList(lotto));

        Lotto winningLotto = new Lotto(
            Arrays.asList(1, 2, 3, 4, 5, 6)
                .stream().map(LottoNumber::new)
                .collect(Collectors.toList()));
        LottoNumber bonusLottoNumber = new LottoNumber(7);
        Winning winning = new Winning(winningLotto, bonusLottoNumber);

        RankResult rankResult = new RankResult(lottos, winning);
        assertThat(rankResult.getTotalPrize().getValue()).isEqualTo(total);
    }
}
