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

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    @DisplayName("숫자 비교를 통해 일치하는 수의 개수를 확인할 수 있다")
    public void integer_contain() {
        Lotto lotto = new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        PrizeLotto prizeLotto = new PrizeLotto(new LottoNumber(Arrays.asList(1, 2, 3, 9, 10, 11)));

        assertThat(lotto.prize(prizeLotto)).extracting(Prize::matchCount).isEqualTo(3);
    }

    @ParameterizedTest
    @MethodSource("lottoWithPrize")
    @DisplayName("일치하는 개수별로 등수를 확인할 수 있다")
    public void lotto_prize(Lotto lotto, Prize prize) {
        PrizeLotto prizeLotto = new PrizeLotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(lotto.prize(prizeLotto)).isEqualTo(prize);
    }

    private static Stream<Arguments> lottoWithPrize() {
        return Stream.of(
            Arguments.arguments(new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6))), Prize.FIRST),
            Arguments.arguments(new Lotto(new LottoNumber(Arrays.asList(1, 2, 3, 43, 44, 45))), Prize.FOURTH),
            Arguments.arguments(new Lotto(new LottoNumber(Arrays.asList(40, 41, 42, 43, 44, 45))), Prize.SEVENTH)
        );
    }

}
