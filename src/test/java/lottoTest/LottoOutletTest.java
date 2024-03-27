package lottoTest;

import lotto.model.Lotto;
import lotto.model.LottoOutlet;
import lotto.model.MatchNumber;
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

    @ParameterizedTest(name = "{0} 가격으로 구매가능한 로또 장수는 {1}")
    @CsvSource(value = {"14000:14", "1000:1", "1500:1", "7500:7"}, delimiter = ':')
    void moneyToLottoCount(int money, int expectedLottoCount) {
        Assertions.assertThat(LottoOutlet.lottoCount(money)).isEqualTo(expectedLottoCount);
    }

    @Test
    @DisplayName("로또를 발급하는 기능")
    void generateLottoTest() {
        Assertions.assertThat(LottoOutlet.generateLotto()).isInstanceOf(Lotto.class);
    }

    @ParameterizedTest(name = "{0}번 발급하는 기능의 반환은 {0}사이즈의 Lotto리스트 반환")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void generateLottosTest(int count) {
        Assertions.assertThat(LottoOutlet.generateLottos(count).size()).isEqualTo(count);
    }

    @ParameterizedTest(name = "보너스 숫자 외 {0}회 일치하는 당청금은 {1}원 이다.")
    @CsvSource(value = {"1:0", "2:0", "3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void getWinning(int matchCount, int expectedWinning) {
        MatchNumber matchNumber = new MatchNumber(matchCount, false);
        Assertions.assertThat(LottoOutlet.getWinning(matchNumber)).isEqualTo(expectedWinning);
    }

    @ParameterizedTest(name = "보너스 숫자 외 {0}번 일치하는 로또들의 상금은 총 {1} 이다.")
    @MethodSource("generateMatchCountsWinningAmount")
    void getWinnings(List<Integer> matchCounts, int winningAmount) {
        List<MatchNumber> matchNumbers = matchCounts.stream()
                .map(matchCount -> new MatchNumber(matchCount, false))
                .collect(Collectors.toList());

        Assertions.assertThat(LottoOutlet.getWinnings(matchNumbers)).isEqualTo(winningAmount);
    }

    @Test
    @DisplayName("2등은 5개 번호가 일치하고 1개의 보너스 번호가 일치해야 한다.")
    void rankSecoundTest() {
        MatchNumber matchNumber = new MatchNumber(5, true);
        Assertions.assertThat(LottoOutlet.getRank(matchNumber)).isEqualTo(2);
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
