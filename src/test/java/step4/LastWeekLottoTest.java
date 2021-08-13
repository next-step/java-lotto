package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.lottoPlace.LastWeekLotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LastWeekLottoTest {
    @ParameterizedTest
    @DisplayName("지난주 로또 금액을 제대로 입력")
    @MethodSource("lastWeekLottoNumSource")
    public void successLottoInput(List<Integer> manualLottoNums, int bonusNum) {
        //given, when, then
        LastWeekLotto.of(manualLottoNums, bonusNum);
    }

    @ParameterizedTest
    @DisplayName("지난주 로또 금액을 잘못 입력")
    @MethodSource("lastWeekLottoNumErrorSource")
    public void failLottoInput(List<Integer> manualLottoNums, int bonusNum) {
        //given, when, then
        assertThatThrownBy(() -> {
            LastWeekLotto.of(manualLottoNums, bonusNum);
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("지난주 로또 금액을 제대로 입력")
    @MethodSource("lastWeekLottoNumContainsSource")
    public void lastWeekLottoNumsContains(List<Integer> manualLottoNums, int bonusNum, int target, boolean expected) {
        //given
        LastWeekLotto lastWeekLotto = LastWeekLotto.of(manualLottoNums, bonusNum);

        //when
        boolean contains = lastWeekLotto.contains(target);

        //then
        assertThat(contains).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("지난주 로또 금액을 제대로 입력")
    @MethodSource("lastWeekLottoBonusNumCorrectSource")
    public void lastWeekLottoBonusNumCorrect(List<Integer> manualLottoNums, int bonusNum, int target, boolean expected) {
        //given
        LastWeekLotto lastWeekLotto = LastWeekLotto.of(manualLottoNums, bonusNum);

        //when
        boolean contains = lastWeekLotto.isBonusNumCorrect(target);

        //then
        assertThat(contains).isEqualTo(expected);
    }

    static Stream<Arguments> lastWeekLottoNumSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6), 7),
            Arguments.arguments(Arrays.asList(8, 9, 10, 11, 12, 13), 14),
            Arguments.arguments(Arrays.asList(15, 16, 17, 18, 19, 20), 21)
        );
    }

    static Stream<Arguments> lastWeekLottoNumErrorSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6), -7),
            Arguments.arguments(Arrays.asList(8, 9, 10, 11, 12, 13, 14), 14),
            Arguments.arguments(Arrays.asList(15, 16, 17, 18, 19, 19), 21)
        );
    }

    static Stream<Arguments> lastWeekLottoNumContainsSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6), 7, 5, true),
            Arguments.arguments(Arrays.asList(8, 9, 10, 11, 12, 13), 14, 13, true),
            Arguments.arguments(Arrays.asList(15, 16, 17, 18, 19, 20), 21, 45, false)
        );
    }

    static Stream<Arguments> lastWeekLottoBonusNumCorrectSource() {
        return Stream.of(
            Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6), 7, 7, true),
            Arguments.arguments(Arrays.asList(8, 9, 10, 11, 12, 13), 14, 14, true),
            Arguments.arguments(Arrays.asList(15, 16, 17, 18, 19, 20), 21, 45, false)
        );
    }
}
