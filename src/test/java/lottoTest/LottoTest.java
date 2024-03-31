package lottoTest;

import lotto.model.Lotto;
import lotto.model.MatchResult;
import lotto.model.LottoNumber;
import lotto.model.LottoNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTest {

    //테스트용 더미 Number
    private static final LottoNumber DUMMY_LOTTO_NUMBER = new LottoNumber(-1);

    @ParameterizedTest(name = "{1} 로또는 {1} 값을 리스트 반환")
    @MethodSource("generateLotto")
    void lottoGetNumbersTest(Lotto lotto, LottoNumbers lottoNumbers) {
        Assertions.assertThat(lotto.getNumbers()).isEqualTo(lottoNumbers);
    }

    @ParameterizedTest(name = "lotto의 숫자 리스트 사이즈는 6")
    @MethodSource("generateLotto")
    void lottoListSizeTest(Lotto lotto) {
        Assertions.assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }


    @ParameterizedTest(name = "{1} 해당 로또와 {2} 당청 번호 비교시 일치하는 수는 {3} 이다.")
    @MethodSource("createLottoWinningnumbersMatchcount")
    void getMatchNumberCount(Lotto lotto, List<Integer> lottoNumbers, List<Integer> winningNumbers, int expectedMatchCount) {
        Assertions.assertThat(lotto.matchNumbers(LottoNumbers.valueOf(winningNumbers), DUMMY_LOTTO_NUMBER).getMatchCount()).isEqualTo(expectedMatchCount);
    }

    @ParameterizedTest(name = "{1} 로또 번호와 {2} 보너스 번호의 일치 여부는 {3} 이다.")
    @MethodSource("createLottoWinningnumbersBonus")
    void matchBounusTest(Lotto lotto, List<Integer> lottoNumbers, int bonusNumber, boolean expected) {
        MatchResult matchResult = lotto.matchNumbers(LottoNumbers.valueOf(lottoNumbers), new LottoNumber(bonusNumber));
        Assertions.assertThat(matchResult.isMatchBonus()).isEqualTo(expected);
    }

    private static Stream<Arguments> createLottoWinningnumbersBonus() {
        return Stream.of(
                Arguments.arguments(givenLotto(givenNumbers(1, 2, 3, 4, 5, 6)), givenNumbers(1, 2, 3, 4, 5, 6), 1, true),
                Arguments.arguments(givenLotto(givenNumbers(2, 3, 4, 5, 6, 7)), givenNumbers(2, 3, 4, 5, 6, 7), 1, false),
                Arguments.arguments(givenLotto(givenNumbers(3, 4, 5, 6, 7, 8)), givenNumbers(3, 4, 5, 6, 7, 8), 8, true),
                Arguments.arguments(givenLotto(givenNumbers(4, 5, 6, 7, 8, 9)), givenNumbers(4, 5, 6, 7, 8, 9), 23, false),
                Arguments.arguments(givenLotto(givenNumbers(5, 6, 7, 8, 9, 10)), givenNumbers(5, 6, 7, 8, 9, 10), 9, true)
        );
    }


    private static Stream<Arguments> createLottoWinningnumbersMatchcount() {
        return Stream.of(
                Arguments.arguments(givenLotto(givenNumbers(1, 2, 3, 4, 5, 6)), givenNumbers(1, 2, 3, 4, 5, 6), givenNumbers(1, 2, 3, 4, 5, 6), 6),
                Arguments.arguments(givenLotto(givenNumbers(2, 3, 4, 5, 6, 7)), givenNumbers(2, 3, 4, 5, 6, 7), givenNumbers(10, 3, 4, 5, 6, 11), 4),
                Arguments.arguments(givenLotto(givenNumbers(3, 4, 5, 6, 7, 8)), givenNumbers(3, 4, 5, 6, 7, 8), givenNumbers(10, 11, 12, 13, 14, 15), 0),
                Arguments.arguments(givenLotto(givenNumbers(4, 5, 6, 7, 8, 9)), givenNumbers(4, 5, 6, 7, 8, 9), givenNumbers(14, 15, 16, 17, 18, 9), 1),
                Arguments.arguments(givenLotto(givenNumbers(5, 6, 7, 8, 9, 10)), givenNumbers(5, 6, 7, 8, 9, 10), givenNumbers(3, 1, 7, 8, 9, 10), 4)
        );
    }

    private static Stream<Arguments> generateLotto() {
        return Stream.of(
                Arguments.arguments(givenLotto(givenNumbers(1, 2, 3, 4, 5, 6)), LottoNumbers.valueOf(givenNumbers(1, 2, 3, 4, 5, 6))),
                Arguments.arguments(givenLotto(givenNumbers(2, 3, 4, 5, 6, 7)), LottoNumbers.valueOf(givenNumbers(2, 3, 4, 5, 6, 7))),
                Arguments.arguments(givenLotto(givenNumbers(3, 4, 5, 6, 7, 8)), LottoNumbers.valueOf(givenNumbers(3, 4, 5, 6, 7, 8))),
                Arguments.arguments(givenLotto(givenNumbers(4, 5, 6, 7, 8, 9)), LottoNumbers.valueOf(givenNumbers(4, 5, 6, 7, 8, 9))),
                Arguments.arguments(givenLotto(givenNumbers(5, 6, 7, 8, 9, 10)), LottoNumbers.valueOf(givenNumbers(5, 6, 7, 8, 9, 10)))
        );
    }

    private static Lotto givenLotto(List<Integer> integers) {
        return new Lotto(integers);
    }

    private static List<Integer> givenNumbers(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(Integer::new)
                .collect(Collectors.toList());
    }
}
