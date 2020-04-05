package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PriceTest {
    private Price price;

    @Test
    public void lessThanMinimumAmountThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            price = new Price(0);
        }).withMessage("금액은 1000원 이상 입력해주세요.");
    }

    @Test
    public void invalidAmountThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            price = new Price(1500);
        }).withMessage("금액은 1000원 단위로 입력해주세요.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "14000:14"}, delimiter = ':')
    public void getAvailableBuyTicketCountTest(int inputPrice, int ticketCount) {
        price = new Price(inputPrice);
        int availableBuyTicketCount = price.getAvailableBuyTicketCount();
        assertThat(availableBuyTicketCount).isEqualTo(ticketCount);
    }

    @Test
    public void getYield() {
        price = new Price(14000);
        double totalWinningMoney = 5_000;
        assertThat(price.getYield(totalWinningMoney)).isEqualTo(BigDecimal.valueOf(0.36));
    }
}
