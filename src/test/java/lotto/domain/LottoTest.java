package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {


    @DisplayName("로또 인스턴스 생성 테스트")
    @Test
    public void createLottoInstanceTest() {
        //Given & When
        Lotto lotto = Lotto.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        //Then
        assertThat(lotto).isNotNull();
        assertThat(lotto.equals(Lotto.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)))));
    }

    @DisplayName("matchPrizeNumber 메서드 테스트")
    @ParameterizedTest
    @MethodSource("createLottoNumber")
    public void matchPrizeNumberTest(HashSet<Integer> expected) {
        //Given
        Lotto lotto = Lotto.of(expected);

        //When
        PrizeInformation prize = lotto.matchPrizeNumber(new PrizeLotto(Lotto.of(expected), 10));

        //Then
        assertThat(prize).isEqualTo(PrizeInformation.FIRST);
    }

    static Stream<Arguments> createLottoNumber() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(1, 3, 5, 6, 7, 8))),
                Arguments.of(new HashSet<>(Arrays.asList(2, 3, 5, 6, 15, 20))),
                Arguments.of(new HashSet<>(Arrays.asList(2, 3, 5, 6, 8, 30))),
                Arguments.of(new HashSet<>(Arrays.asList(2, 3, 5, 6, 8, 12)))
        );
    }
}