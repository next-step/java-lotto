package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {


    @DisplayName("로또 인스턴스 생성 테스트")
    @Test
    public void createLottoInstanceTest() {

        //Given & When
        Lotto lotto = new Lotto(new TreeSet<>(Arrays.asList(1, 3, 5, 6, 7, 8)));

        //Then
        assertThat(lotto.getLottoPickNumber()).isNotNull();
        assertThat(lotto.getLottoPickNumber()).hasSize(6);
    }

    @DisplayName("matchPrizeNumber 메서드 테스트")
    @ParameterizedTest
    @MethodSource("createLottoNumber")
    public void matchPrizeNumberTest(TreeSet<Integer> expected) {
        //Given
        Lotto lotto = new Lotto(expected);

        //When
        PrizeInformation prizeInformation = lotto.matchPrizeNumber(new PrizeLotto(expected, 5 ));

        //That
        assertThat(prizeInformation).isEqualTo(PrizeInformation.findByPrizePrice(new MatchStatus(prizeInformation.countMatchNumber(), false)));

    }

    static Stream<Arguments> createLottoNumber() {
        return Stream.of(
                Arguments.of(new TreeSet<>(Arrays.asList(1, 3, 5, 6, 7, 8))),
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6, 15, 20))),
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6, 8, 30))),
                Arguments.of(new TreeSet<>(Arrays.asList(2, 3, 5, 6, 8, 12)))
        );
    }
}