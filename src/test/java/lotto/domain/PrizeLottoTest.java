package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeLottoTest {


    @ParameterizedTest
    @MethodSource("createTreeSet")
    public void createInstanceTest(Set<Integer> prizeNumbers) {
        //Given & When
        PrizeLotto prizeLotto = new PrizeLotto(new LottoNumbers(prizeNumbers));

        //Then
        assertThat(prizeLotto).isNotNull();
    }

    static Stream<Arguments> createTreeSet() {
        return Stream.of(
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6, 8, 13))),
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6, 8, 12)))
        );
    }



    @ParameterizedTest
    @MethodSource("createTreeSet")
    public void findByIndexTest(Set<Integer> prizeNumbers) {
        //Given & When
        PrizeLotto prizeLotto = new PrizeLotto(new LottoNumbers(prizeNumbers));

        //Then
        for (int number : prizeNumbers) {
            assertThat(prizeLotto.existByIndexNumber(number)).isTrue();
        }
    }
}