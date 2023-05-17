package lottery;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LotteryCreditTest {
    @Test
    public void charge14Credits() {
        var cash = new Natural(14000);

        var credit = new LotteryCredit();
        credit.chargeWithCash(cash);

        assertThat(credit.getBalance().value()).isEqualTo(14);
    }

    @Test
    public void buyLottery() {
        var cash = new Natural(14000);
        var rows = List.of(
                LotteryRow.fromGiven(Set.of(1, 2, 3, 4, 5, 6))
        );

        var credit = new LotteryCredit();
        credit.chargeWithCash(cash);
        var lotteries = credit.buyLotteries(rows);

        assertThat(lotteries).hasSize(1);
        assertThat(lotteries.get(0).getRow().getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(credit.getBalance().value()).isEqualTo(13);
    }

    @Test
    public void preventBuyingWhenCreditIsEmpty() {
        var cash = new Natural(1000);
        var amountToBuy = new Natural(2);

        var credit = new LotteryCredit();
        credit.chargeWithCash(cash);
        var lotteries = credit.buyLotteriesAuto(amountToBuy);

        assertThat(lotteries).hasSize(1);
        assertThat(credit.getBalance().value()).isEqualTo(0);
    }
}
