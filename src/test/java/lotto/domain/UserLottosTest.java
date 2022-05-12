package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottosTest {
    private UserLottos userLottos;

    @BeforeEach
    void set() {
        userLottos = new UserLottos(List.of(new Lotto("1,2,3,4,5,6"), new Lotto("1,2,3,4,5,6")), 2000);
    }
    @Test
    @DisplayName("로또 번호를 3번 추가 하면 수량은 3개이다.")
    void name() {
        UserLottos userLottos = new UserLottos(3000);
        userLottos.autoCreate();
        userLottos.autoCreate();
        userLottos.autoCreate();
        assertThat(userLottos.getSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 1등 당첨수량은 2개이다.")
    void getWinningResults() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,6"), LottoNumber.valueOf("10"));
        assertThat(userLottos.getWinningResults(winningLotto).getWinningCount(Rank.FIRST)).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 2등 수량 2개의 당첨금은 60000000 이다")
    void getWinningMoney() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,8"), LottoNumber.valueOf("6"));
        assertThat(userLottos.getWinningMoney(winningLotto)).isEqualTo(new Money(60000000));
    }
}
