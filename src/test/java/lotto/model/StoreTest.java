package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StoreTest {

    @Test
    @DisplayName("돈을 받을 뒤 그에 해당하는 물건을 제작한다.")
    void delivery() {
        Store store = new Store();
        List<Lotto> lotteryTickets = store.delivery(14000);
        assertThat(lotteryTickets).hasSize(14);
    }
}