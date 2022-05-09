package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class OperationUtilTest {

    List<Integer> mockNumbers;
    String mockInput;
    int mockPrizeAmount;
    int mockPurchasedAmount;

    @DisplayName("입력된 가격에 따라 구매 가능한 로또 횟수 반환")
    @Test
    void getNumberOfPurchasedTickets() {
        assertThat(OperationUtil.getNumberOfPurchasedTickets(5000))
                .isEqualTo(5);
    }

    @DisplayName("입력된 문자열을 6개의 정수로 이뤄진 리스트로 반환")
    @Test
    void splitStringToNumbers() {
        mockInput = "1, 2, 3, 4, 5, 6";
        mockNumbers = IntStream.rangeClosed(1, 6)
                .boxed()
                .collect(Collectors.toList());

        assertThat(OperationUtil.splitStringToNumbers(mockInput))
                .isEqualTo(mockNumbers);
    }

    @DisplayName("로또의 수익률을 계산해서 반환")
    @Test
    void getRateOfReturn() {
        mockPrizeAmount = 5000;
        mockPurchasedAmount = 4000;

        double result = (double) 1.25;

        assertThat(OperationUtil.getRateOfReturn(mockPrizeAmount, mockPurchasedAmount))
                .isEqualTo(result);
    }
}