package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoNumber.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoGames 테스트")
class LottoGamesTest {

    private List<LottoGame> mockLottoGameList = Arrays.asList(
            new LottoGame(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(4), valueOf(5), valueOf(6)))),
            new LottoGame(new HashSet(Arrays.asList(valueOf(10), valueOf(11), valueOf(12), valueOf(13), valueOf(14), valueOf(15)))),
            new LottoGame(new HashSet(Arrays.asList(valueOf(20), valueOf(21), valueOf(22), valueOf(23), valueOf(24), valueOf(25)))),
            new LottoGame(new HashSet(Arrays.asList(valueOf(30), valueOf(31), valueOf(32), valueOf(33), valueOf(34), valueOf(35)))),
            new LottoGame(new HashSet(Arrays.asList(valueOf(40), valueOf(41), valueOf(42), valueOf(43), valueOf(44), valueOf(45))))
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