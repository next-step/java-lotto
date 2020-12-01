package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeLottoTest {


    @ParameterizedTest
    @MethodSource("createHashSet")
    public void createInstanceTest(Set<Integer> prizeNumbers) {
        //Given & When
        PrizeLotto prizeLotto = new PrizeLotto(Lotto.of(prizeNumbers), 10);

        //Then
        assertThat(prizeLotto).isEqualTo(new PrizeLotto(Lotto.of(prizeNumbers), 10));
    }

    static Stream<Arguments> createHashSet() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(2, 3, 5, 6, 8, 13))),
                Arguments.of(new HashSet<>(Arrays.asList(2, 3, 5, 6, 8, 12)))
        );
    }

    @ParameterizedTest
    @MethodSource("createHashSet")
    public void matchBonusBall(Set<Integer> prizeNumbers) {
        //Given
        int bonusball = 10;
        PrizeLotto prizeLotto = new PrizeLotto(Lotto.of(prizeNumbers), bonusball);

        //When
        boolean expected = prizeLotto.matchBonusBall(LottoNumber.from(bonusball));

        //Then
        assertThat(expected).isTrue();
    }

    @ParameterizedTest
    @MethodSource("createHashSet")
    public void matchLottoNumberTest(Set<Integer> prizeNumbers) {
        //Given
        PrizeLotto prizeLotto = new PrizeLotto(Lotto.of(prizeNumbers), 10);

        //When
        boolean expected = prizeLotto.matchLottoNumber(LottoNumber.from(2));

        //Then
        assertThat(expected).isTrue();
    }


}