package lottery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LotteryTest {
//    로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
//    로또 1장의 가격은 1000원이다.

    @Test
    @DisplayName("로또 구매 개수 테스트")
    void lotteryBuyTest(){
        // Given
        final int amountMoney = 14000;

        // When
        int actual = Lottery.buy(amountMoney);

        // Then
        int expected = 14;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또번호 발급 테스트")
    void lotteryDispenseTest(){
        // When
        List<Integer> lotteryNumbers = Lottery.dispense();

        // Then
        assertThat(lotteryNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨 테스트")
    void getMatchCountTest(){
        // Given
        final List<Integer> lotteryNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final List<Integer> winNumbers = Arrays.asList(4, 5, 6, 7, 8, 9);

        // When
        Long actual = Lottery.matchCount(winNumbers, lotteryNumbers);

        // Then
        assertThat(actual).isEqualTo(3L);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,5000", "4,50000", "5,1500000", "6,2000000000"}, delimiter = ',')
    @DisplayName("당첨금 테스트")
    void prizeTest(Long matchCount, int expectedPrize){

        // When
        int actual = Lottery.prize(matchCount);

        // Then
        assertThat(actual).isEqualTo(expectedPrize);
    }

    @Test
    @DisplayName("수익률 계산")
    void profitRateTest(){
        //Given
        final int totalMoneySpent = 14000;
        final int totalPrize = 5000;

        // When
        BigDecimal actual = Lottery.profitRate(totalPrize, totalMoneySpent);
        System.out.println("actual : " + actual);

        // Then
        BigDecimal expected = BigDecimal.valueOf(0.35);
        assertThat(actual).isEqualTo(expected);

    }
}
