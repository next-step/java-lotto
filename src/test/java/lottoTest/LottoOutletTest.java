package lottoTest;

import lotto.model.LottoOutlet;
import lotto.model.MatchResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoOutletTest {

    private static final int DUMMY_INT = -1;
    private static final MatchResult SECOUND_MATCH_NUMBER = new MatchResult(5, true);

    @ParameterizedTest(name = "{0} 가격으로 구매가능한 로또 장수는 {1}")
    @CsvSource(value = {"14000:14", "1000:1", "1500:1", "7500:7"}, delimiter = ':')
    void moneyToLottoCount(int money, int expectedLottoCount) {
        Assertions.assertThat(LottoOutlet.lottoCount(money)).isEqualTo(expectedLottoCount);
    }

    @Test
    @DisplayName("로또를 발급하는 기능")
    void generateLottoTest() {
        LottoOutlet.generateLotto();
//        Assertions.assertThat(LottoOutlet.generateLotto()).isInstanceOf(Lotto.class);
    }

    @ParameterizedTest(name = "{0}번 발급하는 기능의 반환은 {0}사이즈의 Lotto리스트 반환")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void generateLottosTest(int count) {
        Assertions.assertThat(LottoOutlet.generateLottos(count).size()).isEqualTo(count);
    }

    @ParameterizedTest(name = "보너스 숫자 외 {0}회 일치하는 당청금은 {1}원 이다.")
    @CsvSource(value = {"1:0", "2:0", "3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void getWinning(int matchCount, int expectedWinning) {
        MatchResult matchResult = new MatchResult(matchCount, false);
        Assertions.assertThat(LottoOutlet.getWinning(matchResult)).isEqualTo(expectedWinning);
    }

    @ParameterizedTest(name = "보너스 숫자 외 {0}번 일치하는 로또들의 상금은 총 {1} 이다.")
    @MethodSource("generateMatchCountsWinningAmount")
    void getWinnings(List<Integer> matchCounts, int winningAmount) {
        List<MatchResult> matchResults = matchCounts.stream()
                .map(matchCount -> new MatchResult(matchCount, false))
                .collect(Collectors.toList());

        Assertions.assertThat(LottoOutlet.getWinnings(matchResults)).isEqualTo(winningAmount);
    }

    @Test
    @DisplayName("2등은 5개 번호가 일치하고 1개의 보너스 번호가 일치해야 한다.")
    void rankSecoundTest() {
        Assertions.assertThat(LottoOutlet.getRank(SECOUND_MATCH_NUMBER)).isEqualTo(2);
    }

    @Test
    @DisplayName("2등의 상금은 30_000_000 원이다")
    void rankSecoundWinningsTest() {
        Assertions.assertThat(LottoOutlet.getWinning(SECOUND_MATCH_NUMBER)).isEqualTo(30_000_000);
    }

    private static Stream<Arguments> generateMatchCountsWinningAmount() {
        return Stream.of(
                Arguments.arguments(givenNumbers(1, 1, 2, 1), 0),
                Arguments.arguments(givenNumbers(1, 1, 2, 3), 5000),
                Arguments.arguments(givenNumbers(3, 3, 3, 4), 5000 * 3 + 50000 * 1),
                Arguments.arguments(givenNumbers(6, 0, 0, 0), 2000000000 * 1),
                Arguments.arguments(givenNumbers(0, 3, 4, 5), 5000 + 50000 + 1500000)
        );
    }

    private static List<Integer> givenNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
    }
}
