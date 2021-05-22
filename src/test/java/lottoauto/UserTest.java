package lottoauto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    User user;

    @BeforeEach
    void setUp() {
        user = new User(new Money(14000));
    }

    @DisplayName("돈을 얼마를 가지는지 테스트")
    @Test
    void money() {
        assertThat(user.amountForPurchasingLotto()).isEqualTo(new Money(14000));
    }

    @DisplayName("로또티켓 구매 테스트")
    @Test
    void buyLottoTickets() {
        assertThat(user.countLottoTickets()).isEqualTo(0);
        user.buyLottoTickets(new LottoStore());
        assertThat(user.countLottoTickets()).isEqualTo(14);
    }
}
