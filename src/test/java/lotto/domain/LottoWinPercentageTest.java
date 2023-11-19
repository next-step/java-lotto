package lotto.domain;

import lotto.strategy.TestLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinPercentageTest {

    @ParameterizedTest
    @MethodSource("provideLottoResultGenerateCondition")
    @DisplayName("로또 구입 금액과 로또 당첨 통계를 기준으로 총 수익률을 구한다.")
    void success_lotto_win_percentage(
            List<Lotto> lottos,
            List<Integer> lottoWinNumbers,
            int bonusBall
    ) {
        LottoResult lottoResult = new LottoResult(
                new Lottos(lottos),
                new LottoWinNumbers(lottoWinNumbers),
                new BonusBall(bonusBall)
        );
        LottoWinPercentage lottoWinPercentage = new LottoWinPercentage(14000, lottoResult);
        assertThat(lottoWinPercentage.getRate()).isEqualTo(0.35d);
        assertThat(lottoWinPercentage.isLowerStandard()).isTrue();
    }

    private static Stream<Arguments> provideLottoResultGenerateCondition() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Lotto(new LottoNumbers(new TestLottoGenerator(List.of(1, 2, 3, 7, 8, 9))))
                        ),
                        List.of(1, 2, 3, 4, 5, 6),
                        40
                )
        );
    }

}
