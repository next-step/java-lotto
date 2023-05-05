package lotto;

import lotto.utility.InputConverter;
import lotto.domain.Lotto;
import lotto.domain.LotteryTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTicketsTest {
    @ParameterizedTest
    @CsvSource(value = {"14000, 14", "3500, 3", "5000, 5"})
    @DisplayName("예산으로 로또 구매하기")
    public void purchaseTest(String budget, int expect) {
        LotteryTickets lotteryTickets = new LotteryTickets();

        lotteryTickets.purchase(InputConverter.convertBudgetToNumberOfPurchase(budget));

        List<Lotto> result = lotteryTickets.getLottoBundle();

        assertThat(result.size()).isEqualTo(expect);
    }

}
