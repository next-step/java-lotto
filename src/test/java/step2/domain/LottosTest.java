package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    @DisplayName("구매한 개수만큼 로또를 발급한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 100})
    public void issueLottoTest(int purchaseAmount) {
        assertThat(new Lottos(purchaseAmount, new SimpleNumberGenerator()).getAmount()).isEqualTo(purchaseAmount);
    }
}
