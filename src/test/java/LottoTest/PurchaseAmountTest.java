package LottoTest;

import lotto.domain.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PurchaseAmountTest {
    @Test
    @DisplayName(" 인스턴스 생성")
    void When_New_Then_InstanceCreate() {
        assertDoesNotThrow(() -> {
            new PurchaseAmount(1000);
        });
    }

    @Test
    @DisplayName("인스턴스 생성 시 수동 게임 개수 받기")
    void Given_NumberOfManualGames_When_New_Then_NoException() {
        int numberOfManualGames = 1;
        assertDoesNotThrow(() -> {
            new PurchaseAmount(1000, numberOfManualGames);
        });
    }

    @Test
    @DisplayName("수동 게임이 돈보다 많으면 Exception")
    void Given_TooMuchNumberOfManualGames_When_New_Then_Exception() {
        int numberOfManualGames = 100;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PurchaseAmount(1000, numberOfManualGames));
    }

    @Test
    @DisplayName("1000원보다 작으면 Exception")
    void Given_LittleMoney_When_New_Then_Exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PurchaseAmount(900));
    }

    @Test
    @DisplayName("구매금액 테스트")
    void When_PurchaseAmount_Then_RightAmount() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(10200);
        assertThat(purchaseAmount.purchaseAmount()).isEqualTo(10000);
    }

}
