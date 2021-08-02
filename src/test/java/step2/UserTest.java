package step2;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {


    @Test
    void 사용자는_10000원으로_로또를_10개_살_수_있다() {
        // Given
        int givenWallet = 10000;
        User user = new User("Pobi");
        // When
        List<Lotto> userLottos = user.buyLotto(new Wallet(givenWallet));
        // Then
        assertThat(userLottos.size()).isEqualTo(10);
    }

    @Test
    void 사용자는_돈을_지갑에_돈을_보관_할_수_있다() {
        // Given
        Wallet wallet = new Wallet(10000);
        // When

        // Then

    }
}
