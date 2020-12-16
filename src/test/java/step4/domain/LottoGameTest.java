package step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.LottoGame;
import step4.domain.Rank;
import step4.domain.generator.LottoAutoGenerator;
import step4.domain.generator.LottoManualGenerator;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static step4.domain.Rank.*;
import static step4.domain.generator.LottoAutoGeneratorTest.assertionLottoNumberTest;

class LottoGameTest {

    private LottoGame lottoGame;
    private LottoAutoGenerator mockLottoAutoGenerator;

    @BeforeEach
    void setUp() {
        mockLottoAutoGenerator = mock(LottoAutoGenerator.class);
    }

    @Test
    @DisplayName("로또 1장을 구매하였을 때 로또 번호 조건에 맞는지 기능 테스트 (로또는 6개의 숫자 && 각 숫자는 0~45이다)")
    void buyLottoNumber() {
        lottoGame = new LottoGame(BigDecimal.valueOf(1000), new LottoAutoGenerator());
        assertionLottoNumberTest(lottoGame.buyLottoNumber());
    }

    @ParameterizedTest
    @MethodSource("generateLottoGameData")
    @DisplayName("로또 1장(1~6)을 구매했을 때 당첨번호 및 보너스번호와 비교하여 랭킹을 가져오는 기능 테스트")
    void winningResult(String input, int bonusNumber, Rank rank) {
        when(mockLottoAutoGenerator.generate()).thenReturn(new LottoManualGenerator().generate("1,2,3,4,5,6"));
        lottoGame = new LottoGame(BigDecimal.valueOf(1000), mockLottoAutoGenerator);
        Assertions.assertTrue(lottoGame.lottoResultMap(input, bonusNumber).winningResult().containsKey(rank));
    }

    static Stream<Arguments> generateLottoGameData() {
        return Stream.of(
                Arguments.of("1,2,13,14,15,16", 18, MISS),
                Arguments.of("1,2,3,14,15,16", 18, FIFTH),
                Arguments.of("1,2,3,4,15,16", 18, FOURTH),
                Arguments.of("1,2,3,4,5,16", 18, THIRD),
                Arguments.of("1,2,3,4,5,16", 6, SECOND),
                Arguments.of("1,2,3,4,5,6", 18, FIRST)
        );
    }


}