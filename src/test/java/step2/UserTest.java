package step2;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserTest {


    @Test
    void 사용자는_10000원으로_로또를_10개_살_수_있다() {
        // Given
        Integer givenWallet = 10000;
        User user = new User("Pobi");
        // When
        List<Lotto> userLottos = user.buyLotto(givenWallet);
        // Then
        assertThat(userLottos.size()).isEqualTo(10);
    }
}
