package step2.domain.entity;

import org.junit.jupiter.api.Test;
import step2.domain.vo.LottoPrize;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {

    @Test
    void 당첨상태와_일치하는_당첨의_갯수를_구한다() {
        final List<LottoPrize> lottoPrizes = List.of(
                LottoPrize.THIRD, LottoPrize.THIRD, LottoPrize.FOURTH
        );

        final var actual = Lottos.getLottoRankCount(LottoPrize.THIRD, lottoPrizes);

        assertThat(actual).isEqualTo(2);
    }

    @Test
    void 로또_당첨_수익률을_계산한다() {
        final var lottos = createTestLottos();
        final var lottoPrizes = List.of(LottoPrize.FOURTH, LottoPrize.FOURTH);

        final var actual = lottos.getTotalRate(lottoPrizes);

        assertThat(actual).isEqualTo(5.0);
    }

    private Lottos createTestLottos() {
        final var lotto1 = LottoFactory.createAutoLotto(1, 2, 3, 4, 5, 6);
        final var lotto2 = LottoFactory.createAutoLotto(1, 2, 3, 4, 5, 6);

        return new Lottos(List.of(lotto1, lotto2));
    }

}
