package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.PrizeLotto;
import step2.domain.type.Prize;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeTest {

    @Test
    @DisplayName("맞춘 개수에 따라 당첨 금액을 가져올 수 있다")
    public void prize_per_count() {
        Lotto lotto = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        PrizeLotto prizeLotto = new PrizeLotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        assertThat(Prize.of(lotto, prizeLotto)).extracting(Prize::prizeMoney).isEqualTo(BigDecimal.valueOf(2000000000));
    }

    @ParameterizedTest
    @MethodSource("lottoWithPrize")
    @DisplayName("일치하는 개수별로 등수를 확인할 수 있다")
    public void lotto_prize(Lotto lotto, Prize prize) {
        PrizeLotto prizeLotto = new PrizeLotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        assertThat(Prize.of(lotto, prizeLotto)).isEqualTo(prize);
    }

    private static Stream<Arguments> lottoWithPrize() {
        return Stream.of(
            Arguments.arguments(new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))), Prize.FIRST),
            Arguments.arguments(new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 43, 44, 45))), Prize.FOURTH),
            Arguments.arguments(new Lotto(new LottoNumber(Arrays.asList(40, 41, 42, 43, 44, 45))), Prize.SEVENTH)
        );
    }

    @Test
    @DisplayName("5개 일치, 보너스볼 일치 시 등수를 확인할 수 있다")
    public void second_with_bonus_prize() {
        Lotto lotto = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 7)));
        PrizeLotto prizeLotto = new PrizeLotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        assertThat(Prize.of(lotto, prizeLotto)).isEqualTo(Prize.SECOND_WITH_BONUS);
    }

}
