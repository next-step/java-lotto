package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoNumber.from;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoGames 테스트")
class LottoGamesTest {

    private List<LottoGame> mockLottoGameList = Arrays.asList(
            new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(5), from(6)))),
            new LottoGame(new HashSet(Arrays.asList(from(10), from(11), from(12), from(13), from(14), from(15)))),
            new LottoGame(new HashSet(Arrays.asList(from(20), from(21), from(22), from(23), from(24), from(25)))),
            new LottoGame(new HashSet(Arrays.asList(from(30), from(31), from(32), from(33), from(34), from(35)))),
            new LottoGame(new HashSet(Arrays.asList(from(40), from(41), from(42), from(43), from(44), from(45))))
    );

    @ParameterizedTest
    @DisplayName("get_정상")
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void get_정상(int index) {
        // Given
        LottoGame expectedResult = mockLottoGameList.get(index);
        LottoGames lottoGames = new LottoGames(mockLottoGameList);

        // When
        LottoGame actualResult = lottoGames.get(index);

        // Then
        assertEquals(expectedResult, actualResult);
    }
}