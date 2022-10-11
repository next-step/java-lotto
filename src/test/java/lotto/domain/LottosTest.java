package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void 당첨_로또에따른_결과_리스트를_반환() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 7"),
                new Lotto("1, 2, 3, 4, 7, 8"),
                new Lotto("1, 2, 3, 6, 7, 8")
        ));

        Lotto winning = new Lotto("1, 2, 3, 4, 5, 6");

        assertThat(lottos.getResults(winning)).isEqualTo(Arrays.asList(
                LottoResult.FirstPrize,
                LottoResult.SecondPrize,
                LottoResult.ThirdPrize,
                LottoResult.ThirdPrize
        ));
    }

    @Test
    void 원하는_갯수만큼_로또번호를_발행() {
        assertThat(new Lottos(2).getSize()).isEqualTo(2);
    }
}
