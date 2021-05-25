package lotto.domain;

import lotto.dto.PurchaseMoney;
import lotto.exception.NotEnoughMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoNumber.from;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoSellerTest 테스트")
class LottoSellerTest {

    private List<LottoGame> mockLottoGameList = Arrays.asList(
            new LottoGame(new HashSet(Arrays.asList(from(1), from(2), from(3), from(4), from(5), from(6)))),
            new LottoGame(new HashSet(Arrays.asList(from(10), from(11), from(12), from(13), from(14), from(15)))),
            new LottoGame(new HashSet(Arrays.asList(from(20), from(21), from(22), from(23), from(24), from(25)))),
            new LottoGame(new HashSet(Arrays.asList(from(30), from(31), from(32), from(33), from(34), from(35)))),
            new LottoGame(new HashSet(Arrays.asList(from(40), from(41), from(42), from(43), from(44), from(45))))
    );

    private LottoGameGenerator mockLottoGameGenerator = new LottoGameGenerator() {
        private int currentIndex = 0;

        @Override
        public LottoGame generate() {
            LottoGame result = mockLottoGameList.get(currentIndex++);
            if (currentIndex == mockLottoGameList.size()) {
                currentIndex = 0;
            }
            return result;
        }
    };

    @Test
    @DisplayName("sell_정상")
    void sell_정상() {
        // Given
        LottoGames expectedResult = new LottoGames(mockLottoGameList);
        LottoSeller lottoSeller = new LottoSeller(mockLottoGameGenerator);
        PurchaseMoney purchaseMoney = new PurchaseMoney(5_000);

        // When
        LottoGames actualResult = lottoSeller.sell(purchaseMoney);

        // Then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("sell_예외")
    void sell_예외() {
        // Given
        LottoSeller lottoSeller = new LottoSeller(new LottoGameAutoGenerator());
        PurchaseMoney purchaseMoney = new PurchaseMoney(990);

        // When, Then
        assertThatExceptionOfType(NotEnoughMoneyException.class)
                .isThrownBy(() -> lottoSeller.sell(purchaseMoney));
    }
}