package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

    private static User user;

    @BeforeAll
    static void setUp() {
        List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
            new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(10)))
        );
        user = new User(lottos);
    }

    @DisplayName("유저를 잘 생성하는지 테스트한다")
    @Test
    void createUserTest() {
        assertThat(user.getLottos()).hasSize(2);
    }

    @DisplayName("유저는 자신이 산 복권에서 당첨번호가 몇개인지 판단한다")
    @Test
    void matchWinningNumberWithLottos() {
        WinningNumber winningNumber = new WinningNumber(
            Arrays.asList(1, 3, 4, 5, 6, 21), 7);
        List<MatchInfo> matchInfos = user.findEachLottoMatchingNumber(winningNumber);
        assertThat(matchInfos.get(0).getMatchCount()).isEqualTo(5);
        assertThat(matchInfos.get(1).getMatchCount()).isEqualTo(4);
    }
}
