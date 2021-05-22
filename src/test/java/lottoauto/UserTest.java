package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    User user = new User(14000);

    @DisplayName("돈을 얼마를 가지는지 테스트")
    @Test
    void money() {
        assertThat(user.amountForPurchasingLotto()).isEqualTo(14000);
    }

    @DisplayName("로또티켓 구매 테스트")
    @Test
    void buyLottoTickets() {
        assertThat(user.buyLottoTickets(new LottoStore()).size()).isEqualTo(14);
    }
}
