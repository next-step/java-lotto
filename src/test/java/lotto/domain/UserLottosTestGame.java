package lotto.domain;

import lotto.domain.UserLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottosTestGame {
    @Test
    @DisplayName("로또 번호를 3번 추가 하면 수량은 3개이다.")
    void name() {
        UserLottos userLottos = new UserLottos();
        userLottos.autoCreate();
        userLottos.autoCreate();
        userLottos.autoCreate();
        assertThat(userLottos.getSize()).isEqualTo(3);
    }
}
