package AutoLotto.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottoTest {

    @Test
    void canCreateLotto() {
        UserLotto userLotto = new UserLotto();

        assertThat(userLotto.getUserLotto().size()).isEqualTo(6);
        assertThat(userLotto.getUserLotto().get(0).getLottoNumber()).isLessThanOrEqualTo(45);
        assertThat(userLotto.getUserLotto().get(5).getLottoNumber()).isLessThanOrEqualTo(45);
    }
}
