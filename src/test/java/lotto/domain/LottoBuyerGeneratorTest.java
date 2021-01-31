package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerGeneratorTest {

    @DisplayName("입력된 금액과 수동 구매 개수에 따라 로또 구매자 객체를 잘 생성하는지 확인")
    @ParameterizedTest
    @CsvSource({
        "300, 0, 0, 0",
        "3000, 0, 3, 0",
        "3000, 4, 0, 3",
        "8300, 4, 4, 4",
    })
    void generateLottoBuyer(
        int totalCost,
        int manualTicketCnt,
        int calculatedAutoTicketCnt,
        int calculatedManualTicketCnt
    ) {
        assertEquals(
            new LottoBuyer(calculatedAutoTicketCnt, calculatedManualTicketCnt),
            LottoBuyerGenerator.generateLottoBuyer(totalCost, manualTicketCnt)
        );
    }
}