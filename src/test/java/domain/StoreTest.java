package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class StoreTest {

    @Test
    @DisplayName("로또 구매")
    public void buyLottery() {
        Store store = new Store(10000);
        assertThat(store.lotteryCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("로또 최소 구매금액 확인")
    public void validPriceMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Store(100);

            fail("최소금액 에러가 발생해야 한다.");
        });
    }

    @Test
    @DisplayName("나머지 금액 제거 확인")
    public void discard() {
        Store store = new Store(1300);
        assertThat(store.discard(1300)).isEqualTo(1000);
    }

    @Test
    @DisplayName("나머지 금액 제거한 로또 개수 생성")
    public void lotteryCount() {
        Store store = new Store(1300);
        assertThat(store.lotteryCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 구매후 번호 자동생성")
    public void lotteryNumbersAutomatically() {
        LotteryTickets lottery = new LotteryTickets(new Store(1000).lotteryCount());
        assertThat(lottery.lotteryTicket(0).size()).isEqualTo(6);
    }

}
