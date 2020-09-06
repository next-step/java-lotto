package AutoLotto.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottoTest {

    @Test
    void canCreateLotto() {
        UserLotto userLotto = new UserLotto();

        assertThat(userLotto.getLotto().size()).isEqualTo(6);
        assertThat(userLotto.getLotto().get(0).getLottoNumber()).isLessThanOrEqualTo(45);
        assertThat(userLotto.getLotto().get(5).getLottoNumber()).isLessThanOrEqualTo(45);
    }
}
