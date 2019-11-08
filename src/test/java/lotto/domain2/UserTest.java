package lotto.domain2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {

    @ParameterizedTest
    @ValueSource(ints = 10_000)
    void 생성(final int money) {
        User user = new User(money);
        assertThat(user).isEqualTo(new User(money));
    }

    @ParameterizedTest
    @ValueSource(ints = 10_000)
    void 로또구매(final int money) {
        User user = new User(money);
        user.buyLottosIn(new Store(new LottoMachine()));
        WinningLottos winningLottos = user.checkLottos("1, 2, 3, 4, 5, 6");

    }
}
