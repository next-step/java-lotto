package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또는 6개의 숫자로 이루어짐")
    @ParameterizedTest
    @MethodSource("provideLottos")
    void lotto_숫자6개구성(int[] input, int[] expected) {
        Set<LottoNumber> lottoSet = new TreeSet<>(Arrays.stream(input)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
        Set<LottoNumber> expectedSet = new TreeSet<>(Arrays.stream(expected)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));

        Lotto lotto = Lotto.of(LottoNumbers.of(lottoSet));
        assertThat(lotto).isEqualTo(Lotto.of(LottoNumbers.of(expectedSet)));
    }

    private static Stream<Arguments> provideLottos() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 7, 9, 11}, new int[]{1, 3, 5, 7, 9, 11}),
                Arguments.of(new int[]{5, 10, 13, 17, 29, 31}, new int[]{5, 10, 13, 17, 29, 31}),
                Arguments.of(new int[]{21, 33, 34, 37, 40, 45}, new int[]{21, 33, 34, 37, 40, 45})
        );
    }

    @DisplayName("보너스 번호를 포함하고 있는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoForBonusNumber")
    public void containBonusNumber(int[] input, int bonusNumber, boolean expected) {
        Set<LottoNumber> lottoSet = new TreeSet<>(Arrays.stream(input)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
        Lotto lotto = Lotto.of(LottoNumbers.of(lottoSet));
        assertThat(lotto.containBonusNumber(bonusNumber)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoForBonusNumber() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 7, 9, 11}, 3, true),
                Arguments.of(new int[]{5, 10, 13, 17, 29, 31}, 10, true),
                Arguments.of(new int[]{21, 33, 34, 37, 40, 45}, 1, false)
        );
    }

    @DisplayName("로또가 몇개 일치하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoForMatchCount")
    public void matchCountTest(int[] WinningNumber, int[] ExpectedNumber, int expected) {
        Set<LottoNumber> lottoSet = new TreeSet<>(Arrays.stream(WinningNumber)
                .boxed()
                .map(i -> new LottoNumber(i))
                .collect(Collectors.toSet()));
        Lotto lotto = Lotto.of(LottoNumbers.of(lottoSet));
        Set<LottoNumber> expectedSet = new TreeSet<>(Arrays.stream(ExpectedNumber)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
        Lotto expectedLotto = Lotto.of(LottoNumbers.of(expectedSet));

        assertThat(lotto.matchCount(expectedLotto)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLottoForMatchCount() {
        return Stream.of(
                Arguments.of(new int[]{1, 3, 5, 7, 9, 11}, new int[]{1, 3, 5, 7, 9, 10}, 5),
                Arguments.of(new int[]{5, 10, 13, 17, 29, 31}, new int[]{5, 10, 13, 16, 25, 31}, 4),
                Arguments.of(new int[]{21, 33, 34, 37, 40, 45}, new int[]{21, 33, 34, 37, 40, 45}, 6)
        );
    }
}
