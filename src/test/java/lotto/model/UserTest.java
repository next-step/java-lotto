package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    @DisplayName("유저를 잘 생성하는지 테스트")
    @Test
    void createUserTest() {
        List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10))
        );

        User user = new User(lottos);

        assertThat(user.getLottos()).hasSize(2);
    }

    @DisplayName("유저는 자신이 산 복권에서 당첨번호가 몇개인지 판단한다")
    @Test
    void matchWinningNumberWithLottos() {
        List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10))
        );

        User user = new User(lottos);
        WinningNumber winningNumber = new WinningNumber(
            Arrays.asList("1", "3", "4", "5", "6", "21"), 7);
        user.findEachLottoMatchingNumber(winningNumber);
        Lotto lotto1 = user.getLottos().get(0);
        Lotto lotto2 = user.getLottos().get(1);
        assertThat(lotto1.getMatchCount()).isEqualTo(5);
        assertThat(lotto2.getMatchCount()).isEqualTo(4);
    }
}