package step2.domain.entity;

import org.junit.jupiter.api.Test;
import step2.domain.vo.LottoPrize;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    void 당첨상태와_일치하는_당첨의_갯수를_구한다() {
        final List<LottoPrize> lottoPrizes =
                List.of(LottoPrize.THIRD, LottoPrize.THIRD, LottoPrize.FOURTH);
        final var winnerType = new LottoRank(lottoPrizes);


        final var actual = winnerType.getLottoRankCount(LottoPrize.THIRD);

        assertThat(actual).isEqualTo(2);
    }

    @Test
    void 로또_당첨_수익률을_계산한다() {
        final var lottoPrizes = List.of(LottoPrize.FOURTH, LottoPrize.FOURTH);
        final var winnerType = new LottoRank(lottoPrizes);
        final int lottoQuantity = 2;

        final var actual = winnerType.getTotalRate(lottoQuantity);

        assertThat(actual).isEqualTo(5.0);
    }

}