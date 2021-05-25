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

import static lotto.domain.LottoNumber.from;
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
                Arguments.of(new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(5), from(6))))),
                Arguments.of(new LottoGame(new HashSet(Arrays.asList(from(11), from(12), from(13), from(14), from(15), from(16))))),
                Arguments.of(new LottoGame(new HashSet(Arrays.asList(from(21), from(22), from(23), from(24), from(25), from(26)))))
        );
    }

    @Test
    @DisplayName("generate_정상")
    void generate_mock() {
        // Given
        List<LottoGame> list = Arrays.asList(
                new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(5), from(6)))),
                new LottoGame(new HashSet(Arrays.asList(from(10), from(11), from(12), from(13), from(14), from(15)))),
                new LottoGame(new HashSet(Arrays.asList(from(20), from(21), from(22), from(23), from(24), from(25)))),
                new LottoGame(new HashSet(Arrays.asList(from(30), from(31), from(32), from(33), from(34), from(35)))),
                new LottoGame(new HashSet(Arrays.asList(from(40), from(41), from(42), from(43), from(44), from(45))))
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
