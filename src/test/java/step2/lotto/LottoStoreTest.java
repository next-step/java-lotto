package step2.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.controller.LottoStore;
import step2.lotto.client.Client;
import step2.view.ResultView;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @Test
    @DisplayName("sellTo() 테스트")
    void test() {
        long money = 10_000;
        Client client = new Client(money);
        ResultView resultView = new ResultView();
        LottoStore lottoStore = new LottoStore(resultView);
        lottoStore.sellTo(client);

        assertThat(money).isGreaterThan(client.remainMoney());
    }
}