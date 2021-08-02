package step2;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {

    @Test
    void _10000원으로_로또를_10개_살_수_있다() {
        // Given
        Cache givenCache = new Cache(10000);
        Wallet givenWallet = new Wallet(givenCache);
        String givenName = "Pobi";
        User user = new User(givenName, givenWallet);

        // When
        List<Lotto> userLottos = user.buyLotto();

        // Then
        assertThat(userLottos.size()).isEqualTo(10);
    }

    @Test
    void 사용자는_10000이_있는_지갑에서_10000을_인출_할_수_있다() {
        // Given
        Wallet givenWallet = new Wallet(new Cache(10000));
        String givenName = "Pobi";
        User user = new User(givenName, givenWallet);
        Money expectedMoney = new Cache(10000);

        // When
        Money actualMoney = user.withDraw(new Cache(10000));

        // Then
        assertThat(actualMoney).isEqualTo(expectedMoney);
    }

}
