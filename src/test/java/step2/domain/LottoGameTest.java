package step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static step2.domain.LottoGeneratorTest.assertionLottoNumberTest;
import static step2.domain.LottoTest.generateLottoNumber_1to6;

class LottoGameTest {

    private LottoGame lottoGame;
    private LottoNumberGenerator mockLottoNumberGenerator;

    @BeforeEach
    void setUp() {
        mockLottoNumberGenerator = mock(LottoNumberGenerator.class);
    }

    @Test
    @DisplayName("로또 1장을 구매하였을 때 로또 번호 조건에 맞는지 기능 테스트 (로또는 6개의 숫자 && 각 숫자는 0~45이다)")
    void buyLottoNumber() {
        lottoGame = new LottoGame(BigDecimal.valueOf(1000), new LottoNumberGenerator());
        assertionLottoNumberTest(lottoGame.buyLottoNumber());
    }

    @ParameterizedTest
    @MethodSource("generateLottoGameData")
    @DisplayName("로또 1장(1~6)을 구매했을 때 당첨결과와 일치하는 개수 테스트")
    void winningResult(String input, int expected) {
        when(mockLottoNumberGenerator.generate()).thenReturn(generateLottoNumber_1to6());
        lottoGame = new LottoGame(BigDecimal.valueOf(1000), mockLottoNumberGenerator);
        Assertions.assertEquals(lottoGame.lottoResultMap(input).winningResult(expected), 1);
    }

    static Stream<Arguments> generateLottoGameData() {
        return Stream.of(
                Arguments.of("1,2,3,14,15,16", 3),
                Arguments.of("1,2,3,4,15,16", 4),
                Arguments.of("1,2,3,4,5,16", 5),
                Arguments.of("1,2,3,4,5,6", 6)
        );
    }




}