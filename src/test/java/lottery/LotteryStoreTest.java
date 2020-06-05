package lottery;

import lottery.domain.LotteryStore;
import lottery.domain.LotteryTicketsGroup;
import lottery.domain.PurchasePrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryStoreTest {

    @DisplayName("구매 금액에 따라 적합한 개수의 로또 티켓을 정상 구매하는 테스트")
    @ParameterizedTest
    @ValueSource(longs = {1000, 2000, 3000, 4444})
    public void publishLotteryTicketsGroup(long userInput) {
        PurchasePrice purchasePrice = PurchasePrice.of(userInput, 0);
        LotteryStore lotteryStore = LotteryStore.getInstance();
        LotteryTicketsGroup lotteryTicketsGroup = lotteryStore.publishLotteryTicketsGroup(purchasePrice);

        assertThat(lotteryTicketsGroup.getLotteryTicketsNumbers().size())
                .isEqualTo(userInput / 1000);
    }
}
