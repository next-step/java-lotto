package lotto.step2.domain;

import lotto.step2.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @RepeatedTest(3)
    @DisplayName("Lotto 객체를 생성하면, Lotto는 1~45까지의 수를 중복되지 않게 6개 가지고 있다.")
    void testLottoHasUniqueSixNumbers() {
        //given
        Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumbers());

        //when
        Set<Integer> numbers = lotto.nums();

        //then
        assertThat(numbers)
                .hasSize(6)
                .allMatch(number -> number >= 1 && number <= 45);
    }

    @ParameterizedTest
    @MethodSource("generateLottoObjects")
    @DisplayName("Lotto 객체를 toString 하면, 해당 Lotto 객체가 가진 숫자들을 모아서 String으로 반환한다.")
    void testLottoToString(Set<Integer> integerSet, String expectedResult) {
        // given
        Lotto lotto = new Lotto(integerSet);

        // when
        String lottoString = lotto.toString();

        // then
        assertThat(lottoString).isEqualTo(expectedResult);
    }

    public static Stream<Arguments> generateLottoObjects() {
        return Stream.of(
                Arguments.of(new TreeSet<>(Set.of(1, 7, 15, 22, 33, 45)), "[1, 7, 15, 22, 33, 45]"),
                Arguments.of(new TreeSet<>(Set.of(8, 12, 25, 30, 40, 44)), "[8, 12, 25, 30, 40, 44]")
        );
    }
}
