package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoGameGenerator 테스트")
class LottoGameGeneratorTest {

    @ParameterizedTest
    @MethodSource("provideSource_generate_정상")
    @DisplayName("generate_정상")
    void generate_정상(LottoGame expectedResult) {
        // Given
        LottoGameGenerator LottoGameGenerator = () -> expectedResult;

        // When
        LottoGame actualResult = LottoGameGenerator.generate();

        // Then
        assertEquals(expectedResult, actualResult);

    }

    static Stream<Arguments> provideSource_generate_정상() {
        return Stream.of(
                Arguments.of(new LottoGame(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(4), valueOf(5), valueOf(6))))),
                Arguments.of(new LottoGame(new HashSet(Arrays.asList(valueOf(11), valueOf(12), valueOf(13), valueOf(14), valueOf(15), valueOf(16))))),
                Arguments.of(new LottoGame(new HashSet(Arrays.asList(valueOf(21), valueOf(22), valueOf(23), valueOf(24), valueOf(25), valueOf(26)))))
        );
    }

    @Test
    @DisplayName("generate_정상")
    void generate_mock() {
        // Given
        List<LottoGame> list = Arrays.asList(
                new LottoGame(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(4), valueOf(5), valueOf(6)))),
                new LottoGame(new HashSet(Arrays.asList(valueOf(10), valueOf(11), valueOf(12), valueOf(13), valueOf(14), valueOf(15)))),
                new LottoGame(new HashSet(Arrays.asList(valueOf(20), valueOf(21), valueOf(22), valueOf(23), valueOf(24), valueOf(25)))),
                new LottoGame(new HashSet(Arrays.asList(valueOf(30), valueOf(31), valueOf(32), valueOf(33), valueOf(34), valueOf(35)))),
                new LottoGame(new HashSet(Arrays.asList(valueOf(40), valueOf(41), valueOf(42), valueOf(43), valueOf(44), valueOf(45))))
        );

        LottoGameGenerator lottoGameGenerator = new LottoGameGenerator() {

            private int currentIndex = 0;

            @Override
            public LottoGame generate() {
                LottoGame result = list.get(currentIndex++);
                if (currentIndex == list.size()) {
                    currentIndex = 0;
                }
                return result;
            }
        };

        // When, Then
        assertEquals(list.get(0), lottoGameGenerator.generate());
        assertEquals(list.get(1), lottoGameGenerator.generate());
        assertEquals(list.get(2), lottoGameGenerator.generate());
        assertEquals(list.get(3), lottoGameGenerator.generate());
        assertEquals(list.get(4), lottoGameGenerator.generate());
        assertEquals(list.get(0), lottoGameGenerator.generate());
        assertEquals(list.get(1), lottoGameGenerator.generate());
        assertEquals(list.get(2), lottoGameGenerator.generate());
        assertEquals(list.get(3), lottoGameGenerator.generate());
        assertEquals(list.get(4), lottoGameGenerator.generate());
    }
}
