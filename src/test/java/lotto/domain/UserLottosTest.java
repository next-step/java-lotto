package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserLottosTest {
    private UserLottos userLottos;
    private Lotto lotto1;
    private Lotto lotto2;

    @BeforeEach
    void set() {
        lotto1 = new Lotto("1,2,3,4,5,6");
        lotto2 = new Lotto("10,11,12,13,14,15");
        userLottos = new UserLottos(List.of(
                lotto1, lotto1, lotto2));
    }

    @Test
    @DisplayName("로또 번호를 3번 추가 하면 수량은 3개이다.")
    void add() {
        UserLottos userLottos = new UserLottos();
        userLottos.add(lotto1);
        userLottos.add(lotto1);
        userLottos.add(lotto2);
        assertThat(userLottos).isEqualTo(this.userLottos);
    }

    @Test
    @DisplayName("로또 1등 당첨수량은 2개이다.")
    void getWinningResults() {
        WinningLotto winningLotto = new WinningLotto(lotto1, LottoNumber.valueOf("10"));
        assertThat(userLottos.getWinningResults(winningLotto).getWinningCount(Rank.FIRST)).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 2등 수량 2개의 당첨금은 60000000 이다")
    void getWinningMoney() {
        WinningLotto winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,8"), LottoNumber.valueOf("6"));
        assertThat(userLottos.getWinningMoney(winningLotto)).isEqualTo(new Money(60000000));
    }

    @Test
    @DisplayName("객체에 추가된 로또가 없으면 true를 반환한다")
    void isEmptyTrue() {
        assertThat(new UserLottos().isEmpty()).isTrue();
    }

    @Test
    @DisplayName("객체에 추가된 로또가 있으면 false를 반환한다")
    void isEmptyFalse() {
        assertThat(new UserLottos(List.of(lotto1)).isEmpty()).isFalse();
    }
}
