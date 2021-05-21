package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoGameAutoGenerator 테스트")
class LottoGameAutoGeneratorTest {

    LottoGameGenerator lottoGameGenerator = new LottoGameAutoGenerator();

    @RepeatedTest(100)
    @DisplayName("generate_정상")
    void generate_정상() {
        // Given
        int expectedResult = 6;

        // When
        LottoGame lottoGame = lottoGameGenerator.generate();

        // Then
        assertEquals(expectedResult, lottoGame.size());
    }

}