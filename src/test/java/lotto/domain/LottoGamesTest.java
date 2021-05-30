package lotto.domain;

import lotto.dto.PurchaseMoney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoGame.createManual;
import static lotto.domain.LottoNumber.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("LottoGames 테스트")
class LottoGamesTest {

    private List<LottoGame> mockLottoGameListOne;
    private List<LottoGame> mockLottoGameListTwo;

    @BeforeEach
    private void setUp() {
        mockLottoGameListOne = new ArrayList<>();
        mockLottoGameListOne.addAll(Arrays.asList(
                createManual(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(4), valueOf(5), valueOf(6)))),
                createManual(new HashSet(Arrays.asList(valueOf(10), valueOf(11), valueOf(12), valueOf(13), valueOf(14), valueOf(15)))),
                createManual(new HashSet(Arrays.asList(valueOf(20), valueOf(21), valueOf(22), valueOf(23), valueOf(24), valueOf(25)))),
                createManual(new HashSet(Arrays.asList(valueOf(30), valueOf(31), valueOf(32), valueOf(33), valueOf(34), valueOf(35)))),
                createManual(new HashSet(Arrays.asList(valueOf(40), valueOf(41), valueOf(42), valueOf(43), valueOf(44), valueOf(45))))
        ));

        mockLottoGameListTwo = new ArrayList<>();
        mockLottoGameListTwo.addAll(Arrays.asList(
                createManual(new HashSet(Arrays.asList(valueOf(12), valueOf(23), valueOf(31), valueOf(24), valueOf(35), valueOf(36)))),
                createManual(new HashSet(Arrays.asList(valueOf(10), valueOf(11), valueOf(42), valueOf(23), valueOf(14), valueOf(25)))),
                createManual(new HashSet(Arrays.asList(valueOf(20), valueOf(41), valueOf(22), valueOf(23), valueOf(34), valueOf(45))))
        ));
    }

    @ParameterizedTest
    @DisplayName("get_정상")
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void get_정상(int index) {
        // Given
        LottoGame expectedResult = mockLottoGameListOne.get(index);
        LottoGames lottoGames = new LottoGames(mockLottoGameListOne);

        // When
        LottoGame actualResult = lottoGames.get(index);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @DisplayName("equals_정상")
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void equals_정상(int index) {
        // Given
        LottoGames lottoGamesOne = new LottoGames(mockLottoGameListOne);
        LottoGames lottoGamesTwo = new LottoGames(mockLottoGameListOne);

        // When, Then
        assertTrue(lottoGamesOne.equals(lottoGamesTwo));
        assertTrue(lottoGamesTwo.equals(lottoGamesOne));
    }

    @ParameterizedTest
    @DisplayName("get_정상")
    @CsvSource(value = {"3400:3", "5200:5", "8200:8"}, delimiterString = ":")
    void purchaseAuto_정상(int money, int expectedResult) {
        // Given
        PurchaseMoney purchaseMoney = new PurchaseMoney(money);

        // When
        LottoGames lottoGames = LottoGames.purchaseAuto(purchaseMoney);

        // Then
        assertEquals(expectedResult, lottoGames.size());
    }

    @Test
    @DisplayName("merge_정상")
    void merge_정상() {
        // Given
        LottoGames lottoGames = new LottoGames(mockLottoGameListOne);
        LottoGames manualLottoGames = new LottoGames(mockLottoGameListOne);
        int expectedResult = lottoGames.size() + manualLottoGames.size();

        // When
        lottoGames.merge(manualLottoGames);

        // Then
        assertEquals(expectedResult, lottoGames.size());
    }
}