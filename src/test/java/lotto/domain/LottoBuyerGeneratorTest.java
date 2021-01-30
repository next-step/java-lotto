package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LottoBuyerGeneratorTest {

    @DisplayName("입력된 금액에 따라 로또 구매자 객체를 잘 생성하는지 확인")
    @ParameterizedTest
    @CsvSource({
        "300, 0",
        "3000, 3",
        "7300, 7",
    })
    void generateLottoBuyer(int totalCost, int ticketCnt) {
        assertEquals(
            LottoBuyerGenerator.generateLottoBuyer(totalCost),
            new LottoBuyer(ticketCnt)
        );
    }
}