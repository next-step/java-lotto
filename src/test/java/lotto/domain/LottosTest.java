package lotto.domain;

import lotto.domain.generator.StubLottoGenerator;
import lotto.domain.generator.StubLottosGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @ParameterizedTest(name = "로또 자동/수동 객체 생성 확인. {0}, stubAutoLottos={1}, manualLottoNumbers={2}, expectedLottos={3}")
    @MethodSource
    void newLottoInstanceByAutoAndManualCount(String testMessage, List<Lotto> stubAutoLottos, List<String> manualLottoNumbers, List<Lotto> expectedLottos) {

        Lottos lottos = new Lottos(new StubLottosGenerator(stubAutoLottos), new PurchaseAmount(3 * PurchaseAmount.AMOUNT_PER_LOTTO), manualLottoNumbers);

        assertThat(lottos.getLottos()).containsExactlyInAnyOrder(expectedLottos.toArray(new Lotto[0]));
    }

    private static Stream<Arguments> newLottoInstanceByAutoAndManualCount() {

        return Stream.of(
                Arguments.of("자동 1개, 수동 2개",
                             Arrays.asList(new Lotto(new StubLottoGenerator(Arrays.asList(40, 41, 42, 43, 44, 45)))),
                             Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"),
                             Arrays.asList(new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45)),
                                           new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                           new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)))),
                Arguments.of("자동 0개, 수동 3개",
                             Collections.emptyList(),
                             Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12", "13,14,15,16,17,18"),
                             Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                           new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                                           new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18)))),
                Arguments.of("자동 3개, 수동 0개",
                             Arrays.asList(new Lotto(new StubLottoGenerator(Arrays.asList(20, 21, 22, 23, 24, 25))),
                                           new Lotto(new StubLottoGenerator(Arrays.asList(30, 31, 32, 33, 34, 35))),
                                           new Lotto(new StubLottoGenerator(Arrays.asList(40, 41, 42, 43, 44, 45)))),
                             Collections.emptyList(),
                             Arrays.asList(new Lotto(Arrays.asList(20, 21, 22, 23, 24, 25)),
                                           new Lotto(Arrays.asList(30, 31, 32, 33, 34, 35)),
                                           new Lotto(Arrays.asList(40, 41, 42, 43, 44, 45))))
        );
    }

    @ParameterizedTest(name = "로또 수동 생성시 Exception 발생. manualNumbers={0}")
    @EmptySource
    @MethodSource
    void newLottoInstanceOccurredException(List<String> manualNumbers) {

        assertThatThrownBy(() -> new Lottos(new StubLottosGenerator(Collections.emptyList()), new PurchaseAmount(PurchaseAmount.AMOUNT_PER_LOTTO), manualNumbers))
                .isInstanceOfAny(IllegalArgumentException.class, IllegalStateException.class);
    }

    private static Stream<Arguments> newLottoInstanceOccurredException() {

        return Stream.of(
                Arguments.of(Arrays.asList("100, 101, 102, 103, 104, 105")),
                Arguments.of(Arrays.asList("1"))
        );
    }

    @ParameterizedTest(name = "당첨 여부 확인. 당첨 Rule={0}, 로또번호={1}")
    @MethodSource
    void countCorrectsByCompareWonNumbers(PrizeRule prizeRule, List<Integer> lottoNumbers) {

        WonNumbers wonNumbers = new WonNumbers("1, 2, 3, 4, 5, 6", "13");

        List<Lotto> stubLottos = Arrays.asList(new Lotto(new StubLottoGenerator(lottoNumbers)));
        Lottos lottos = new Lottos(new StubLottosGenerator(stubLottos), new PurchaseAmount(stubLottos.size() * PurchaseAmount.AMOUNT_PER_LOTTO), Collections.emptyList());

        assertThat(lottos.isMatchPrizeRule(prizeRule, wonNumbers)).isOne();
    }

    private static Stream<Arguments> countCorrectsByCompareWonNumbers() {

        return Stream.of(
                Arguments.of(PrizeRule.THREE, Arrays.asList(1, 2, 3, 11, 12, 13)),
                Arguments.of(PrizeRule.FOUR, Arrays.asList(1, 2, 3, 4, 12, 13)),
                Arguments.of(PrizeRule.FIVE, Arrays.asList(1, 2, 3, 4, 5, 7)),
                Arguments.of(PrizeRule.FIVE_WITH_BONUS, Arrays.asList(1, 2, 3, 4, 5, 13)),
                Arguments.of(PrizeRule.SIX, Arrays.asList(1, 2, 3, 4, 5, 6))
        );
    }
}