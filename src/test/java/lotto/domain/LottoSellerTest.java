package lotto.domain;

import lotto.dto.PurchaseMoney;
import lotto.exception.NotEnoughMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static lotto.domain.LottoNumber.valueOf;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LottoSellerTest 테스트")
class LottoSellerTest {

    private List<LottoGame> mockLottoGameList = Arrays.asList(
            new LottoGame(new HashSet(Arrays.asList(valueOf(1), valueOf(2), valueOf(3), valueOf(4), valueOf(5), valueOf(6)))),
            new LottoGame(new HashSet(Arrays.asList(valueOf(10), valueOf(11), valueOf(12), valueOf(13), valueOf(14), valueOf(15)))),
            new LottoGame(new HashSet(Arrays.asList(valueOf(20), valueOf(21), valueOf(22), valueOf(23), valueOf(24), valueOf(25)))),
            new LottoGame(new HashSet(Arrays.asList(valueOf(30), valueOf(31), valueOf(32), valueOf(33), valueOf(34), valueOf(35)))),
            new LottoGame(new HashSet(Arrays.asList(valueOf(40), valueOf(41), valueOf(42), valueOf(43), valueOf(44), valueOf(45))))
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
//        LottoGames expectedResult = new LottoGames(mockLottoGameList);
//        LottoSeller lottoSeller = new LottoSeller(mockLottoGameGenerator);
//        PurchaseMoney purchaseMoney = new PurchaseMoney(5_000);
//
//        // When
//        LottoGames actualResult = lottoSeller.sell(purchaseMoney);
//
//        // Then
//        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("sell_예외")
    void sell_예외() {
        // Given
//        LottoSeller lottoSeller = new LottoSeller(new LottoGameAutoGenerator());
//        PurchaseMoney purchaseMoney = new PurchaseMoney(990);
//
//        // When, Then
//        assertThatExceptionOfType(NotEnoughMoneyException.class)
//                .isThrownBy(() -> lottoSeller.sell(purchaseMoney));
    }
}