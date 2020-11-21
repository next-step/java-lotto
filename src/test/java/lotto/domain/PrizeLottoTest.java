package lotto.domain;

import lotto.domain.exception.ErrorMessage;
import lotto.domain.exception.NotValidLottoNumberException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PrizeLottoTest {


    @ParameterizedTest
    @MethodSource("createTreeSet")
    public void createInstanceTest(Set<Integer> prizeNumbers) {
        //Given & When
        PrizeLotto prizeLotto = new PrizeLotto(new TreeSet<>(prizeNumbers));

        //Then
        assertThat(prizeLotto).isNotNull();
        assertThat(prizeLotto.size()).isEqualTo(prizeNumbers.size());
    }

    static Stream<Arguments> createTreeSet() {
        return Stream.of(
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6, 8, 13))),
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6, 8, 12)))
        );
    }

    @ParameterizedTest
    @MethodSource("notValidCreateNumber")
    public void notValidPrizeNumberTest(Set<Integer> prizeNumbers) {
        assertThatThrownBy(() -> {
            PrizeLotto prizeLotto = new PrizeLotto(prizeNumbers);
        }).isInstanceOf(NotValidLottoNumberException.class)
                .hasMessage(ErrorMessage.NOT_VALID_LOTTO_NUMBER.getMessage());
    }

    static Stream<Arguments> notValidCreateNumber() {
        return Stream.of(
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6, 10, 13))),
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6))),
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 10, 20, 30, 35, 40))),
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 10, 20, 30, 46)))
        );
    }


    @ParameterizedTest
    @MethodSource("createTreeSet")
    public void findByIndexTest(Set<Integer> prizeNumbers) {
        //Given & When
        PrizeLotto prizeLotto = new PrizeLotto(new TreeSet<>(prizeNumbers));

        //Then
        for (int number : prizeNumbers) {
            assertThat(prizeLotto.findByIndexNumber(number)).isTrue();
        }
    }
}