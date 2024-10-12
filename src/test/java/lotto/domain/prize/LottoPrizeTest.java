package lotto.domain.prize;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPrizeTest {

    @Test
    void 일치개수별_로또등수_정상_반환() {
        assertThat(LottoPrize.from(6, false)).isEqualTo(LottoPrize.FIRST);
        assertThat(LottoPrize.from(6, true)).isEqualTo(LottoPrize.FIRST);

        assertThat(LottoPrize.from(5, true)).isEqualTo(LottoPrize.SECOND_WITH_BONUS);
        assertThat(LottoPrize.from(5, false)).isEqualTo(LottoPrize.SECOND);

        assertThat(LottoPrize.from(4, false)).isEqualTo(LottoPrize.THIRD);
        assertThat(LottoPrize.from(4, true)).isEqualTo(LottoPrize.THIRD);

        assertThat(LottoPrize.from(3, false)).isEqualTo(LottoPrize.FOURTH);
        assertThat(LottoPrize.from(3, true)).isEqualTo(LottoPrize.FOURTH);

        assertThat(LottoPrize.from(2, true)).isEqualTo(LottoPrize.NOTHING);
        assertThat(LottoPrize.from(2, false)).isEqualTo(LottoPrize.NOTHING);

        assertThat(LottoPrize.from(1, false)).isEqualTo(LottoPrize.NOTHING);
        assertThat(LottoPrize.from(1, true)).isEqualTo(LottoPrize.NOTHING);

        assertThat(LottoPrize.from(0, false)).isEqualTo(LottoPrize.NOTHING);
        assertThat(LottoPrize.from(0, true)).isEqualTo(LottoPrize.NOTHING);
    }

    @Test
    void 등수별_로또상금_정상_계산() {
        Arrays.stream(LottoPrize.values()).forEach(lottoPrize -> {
            int quantity = new Random().nextInt(10) + 1;
            assertThat(lottoPrize.prize(quantity)).isEqualTo(lottoPrize.getPrize() * quantity);
        });
    }
}
