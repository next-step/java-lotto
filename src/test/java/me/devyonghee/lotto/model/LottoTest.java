package me.devyonghee.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("로또")
class LottoTest {

    @Test
    @DisplayName("로또 번호 6개로 로또 정상 생성")
    void instance() {
        assertThatNoException().isThrownBy(() -> Lotto.auto(LottoNumbersTest.ONE_TO_SIX_NUMBERS));
    }

    @Test
    @DisplayName("숫자들은 필수")
    void instance_nullNumbers_thrownNullPointerException() {
        assertThatNullPointerException().isThrownBy(() -> Lotto.auto(null));
    }

    @ParameterizedTest
    @DisplayName("로또 번호는 6개")
    @MethodSource
    void instance_invalidNumber_thrownIllegalArgumentException(List<LottoNumber> numbers) {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.auto(LottoNumbers.from(numbers)));
    }

    @ParameterizedTest(name = "[{index}] 1,2,3,4,5,6과 {0} 대해서 랭크를 계산하면 {1}")
    @DisplayName("1,2,3,4,5,6 로또에 대한 순위 계산")
    @MethodSource
    void rank(Lotto target, LottoNumber bonusNumber, Rank expected) {
        //given
        Lotto lotto = lotto(1, 2, 3, 4, 5, 6);
        //when
        assertThat(lotto.rank(target, bonusNumber)).isEqualTo(expected);
    }

    @Test
    @DisplayName("주어진 로또 번호들에 대해서 그대로 반환")
    void numbers() {
        assertThat(Lotto.auto(LottoNumbersTest.ONE_TO_SIX_NUMBERS).numbers()).isEqualTo(LottoNumbersTest.ONE_TO_SIX_NUMBERS);
    }

    @ParameterizedTest(name = "[{index}] 1,2,3,4,5,6 로또에 {0} 숫자 포함은 {1}")
    @DisplayName("1 부터 6까지의 로또에 숫자 포함 여부")
    @CsvSource({"1,true", "6,true", "7,false"})
    void contains(int number, boolean expected) {
        assertThat(Lotto.auto(LottoNumbersTest.ONE_TO_SIX_NUMBERS).contains(LottoNumber.from(number))).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("수동 로또 여부")
    @MethodSource
    void isManual(Lotto lotto, boolean expected) {
        assertThat(lotto.isManual()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("자동 로또 여부")
    @MethodSource
    void isAuto(Lotto lotto, boolean expected) {
        assertThat(lotto.isAuto()).isEqualTo(expected);
    }

    private static Stream<Arguments> instance_invalidNumber_thrownIllegalArgumentException() {
        return Stream.of(
                Arguments.of(Collections.singletonList(LottoNumber.from(1))),
                Arguments.of(IntStream.rangeClosed(1, 7).mapToObj(LottoNumber::from).collect(Collectors.toList()))
        );
    }

    private static Stream<Arguments> rank() {
        return Stream.of(
                Arguments.of(lotto(1, 2, 3, 4, 5, 6), LottoNumber.from(7), Rank.FIRST),
                Arguments.of(lotto(2, 3, 4, 5, 6, 7), LottoNumber.from(1), Rank.SECOND),
                Arguments.of(lotto(2, 3, 4, 5, 6, 7), LottoNumber.from(8), Rank.THIRD),
                Arguments.of(lotto(3, 4, 5, 6, 7, 8), LottoNumber.from(1), Rank.FOURTH),
                Arguments.of(lotto(4, 5, 6, 7, 8, 9), LottoNumber.from(1), Rank.FIFTH),
                Arguments.of(lotto(5, 6, 7, 8, 9, 10), LottoNumber.from(1), Rank.NOTHING)
        );
    }

    private static Lotto lotto(int first, int second, int third, int fourth, int fifth, int sixth) {
        return Lotto.auto(LottoNumbers.from(
                Arrays.asList(
                        LottoNumber.from(first),
                        LottoNumber.from(second),
                        LottoNumber.from(third),
                        LottoNumber.from(fourth),
                        LottoNumber.from(fifth),
                        LottoNumber.from(sixth)
                )
        ));
    }

    private static Stream<Arguments> isManual() {
        return Stream.of(
                Arguments.of(Lotto.manual(LottoNumbersTest.ONE_TO_SIX_NUMBERS), true),
                Arguments.of(Lotto.auto(LottoNumbersTest.ONE_TO_SIX_NUMBERS), false)
        );
    }

    private static Stream<Arguments> isAuto() {
        return Stream.of(
                Arguments.of(Lotto.manual(LottoNumbersTest.ONE_TO_SIX_NUMBERS), false),
                Arguments.of(Lotto.auto(LottoNumbersTest.ONE_TO_SIX_NUMBERS), true)
        );
    }
}
