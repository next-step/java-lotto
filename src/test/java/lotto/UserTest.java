package lotto;

import lotto.domain.LottoSeller;
import lotto.domain.User;
import lotto.utils.TestNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {

    private final LottoSeller mockLottoSeller = new LottoSeller(new TestNumberGenerator(List.of(1,2,3,4,5,6)));

    @ParameterizedTest
    @DisplayName("로또 구매 테스트")
    @CsvSource(value = {"14000,14", "4000,4", "1000,1"}, delimiter = ',')
    void testPurchaseLotto(int price, int expected) {
        User user = new User(mockLottoSeller);
        user.purchaseLottos(price);
        assertThat(user.getLottos()).hasSize(expected);
    }

    @ParameterizedTest
    @DisplayName("올바르지 않은 가격으로 로또 살 때 테스트")
    @ValueSource(ints = {100, 1200, 12300})
    void testInvalidPurchase(int price) {
        User user = new User(mockLottoSeller);
        assertThatIllegalArgumentException().isThrownBy(() -> user.purchaseLottos(price));
    }

}
