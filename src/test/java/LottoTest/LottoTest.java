package LottoTest;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    LottoNumberGenerator lottoNumberGenerator = new FixedLottoNumberGenerator();

    @Test
    @DisplayName("로또 게임 구매 테스트")
    void When_Game_Then_LottoNumberList() {
        int money = 10000;
        Lotto lotto = new Lotto(money, lottoNumberGenerator);
        List<LottoNumber> games = lotto.games();
        assertThat(games.size()).isEqualTo(money / 1000);
    }

    @Test
    @DisplayName("우승자 계산 테스트")
    void When_Result() {
        int Money = 10000;
        Lotto lotto = new Lotto(Money, lottoNumberGenerator);
        WinningNumber winningNumber = new WinningNumber(new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);

        Winners winners = lotto.winners(winningNumber);

        assertThat(winners.wins(Rank.FIRST)).isEqualTo(10);
    }
}
