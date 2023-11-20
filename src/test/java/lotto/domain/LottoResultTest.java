package lotto.domain;

import lotto.strategy.TestLottoGenerator;
import lotto.testutil.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @ParameterizedTest
    @MethodSource("provideLottoResultGenerateCondition")
    @DisplayName("성공 - 입력 받은 로또와 당첨 번호, 보너스 볼을 토대로 로또 결과를 생성한다.")
    void success_generate_lotto_result(
            List<Integer> lottoNumbers,
            List<Integer> lottoWinNumbers,
            int bonusBall,
            LottoRank expectLottoRank
    ) {
        LottoResult lottoResult = new LottoResult(
                new Lottos(List.of(new Lotto(new LottoNumbers(new TestLottoGenerator(TestUtil.generateLottoNumbers(lottoNumbers)))))),
                new LottoWinNumbers(TestUtil.generateLottoNumbers(lottoWinNumbers)), new BonusBall(bonusBall)
        );
        assertThat(lottoResult.getLottoResult().containsKey(expectLottoRank)).isTrue();
    }

    private static Stream<Arguments> provideLottoResultGenerateCondition() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 7, 8, 9),
                        List.of(1, 2, 3, 4, 5, 6),
                        40,
                        LottoRank.FIFTH
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 8, 9),
                        List.of(1, 2, 3, 4, 5, 6),
                        40,
                        LottoRank.FOURTH
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 9),
                        List.of(1, 2, 3, 4, 5, 6),
                        40,
                        LottoRank.THIRD
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 40),
                        List.of(1, 2, 3, 4, 5, 6),
                        40,
                        LottoRank.SECOND
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6),
                        List.of(1, 2, 3, 4, 5, 6),
                        40,
                        LottoRank.FIRST
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideLottoStatisticsGenerateCondition")
    @DisplayName("성공 - 로또 결과를 토대로 총 당첨 금액을 구한다.")
    void success_generate_lotto_sum(
            List<Lotto> lottos,
            List<Integer> lottoWinNumbers,
            int bonusBall
    ) {
        LottoResult lottoResult = new LottoResult(
                new Lottos(lottos),
                new LottoWinNumbers(TestUtil.generateLottoNumbers(lottoWinNumbers)),
                new BonusBall(bonusBall)
        );

        int lottoSum = lottoResult.totalLottoIncome();

        assertThat(lottoSum).isEqualTo(2_031_555_000L);
    }

    private static Stream<Arguments> provideLottoStatisticsGenerateCondition() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                new Lotto(new LottoNumbers(new TestLottoGenerator(TestUtil.generateLottoNumbers(List.of(1, 2, 3, 7, 8, 9))))),
                                new Lotto(new LottoNumbers(new TestLottoGenerator(TestUtil.generateLottoNumbers(List.of(1, 2, 3, 4, 8, 9))))),
                                new Lotto(new LottoNumbers(new TestLottoGenerator(TestUtil.generateLottoNumbers(List.of(1, 2, 3, 4, 5, 9))))),
                                new Lotto(new LottoNumbers(new TestLottoGenerator(TestUtil.generateLottoNumbers(List.of(1, 2, 3, 4, 5, 40))))),
                                new Lotto(new LottoNumbers(new TestLottoGenerator(TestUtil.generateLottoNumbers(List.of(1, 2, 3, 4, 5, 6)))))
                        ),
                        List.of(1, 2, 3, 4, 5, 6),
                        40
                )
        );
    }

}
